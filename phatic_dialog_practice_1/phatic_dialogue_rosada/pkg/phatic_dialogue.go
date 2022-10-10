package pkg

import (
	"encoding/json"
	"io/ioutil"
	"math/rand"
	"os"
	"regexp"
	"strings"
)

type PhaticDialogue struct {
	ExactMatch []Dictionary`json:"exact_match"`
	ReplacementTemplate []Dictionary`json:"replacement_template"`
	MatchingRules []Dictionary `json:"matching_rules:"`
	UniversalAnswers []string `json:"universal_answers"`
}

func NewPhaticDialogue() (*PhaticDialogue, error) {
	data, err := readBytes("pkg/templates_data.json")
	if err != nil{
		return &PhaticDialogue{}, err
	}
	phatic := &PhaticDialogue{}
	err = json.Unmarshal(data, phatic)
	if err != nil {
		return nil, err
	}
	return phatic, nil
}

type Dictionary struct{
	Template string `json:"template"`
	Answer   string `json:"answer"`
}

// Отримання відповіді на репліку користувача
func (p *PhaticDialogue) GetAnswer(phrase string) string {
	phrase = strings.ToLower(phrase)
	answers := p.getExactMatch(phrase)
	if len(answers) > 0{
		return getRandomString(answers)
	}
	answers = p.getFromTemplate(phrase)
	answers = append(answers, p.getFromRules(phrase)...)
	// Надання універсальної відповіді, якщо не знайшлось підходящого шаблону
	if len(answers) == 0{
		return getRandomString(p.UniversalAnswers)
	}
	return getRandomString(answers)
}

// Отримання відповіді, з повного збігу шаблону і фразою користувача
func (p *PhaticDialogue) getExactMatch(phrase string)[]string{
	return getAnswer(p.ExactMatch, phrase, func(t string,p string) bool { 
		return t == p
	}, nil)
}

// Отримання відповідей, якщо фраза відповідає шаблонам із замінювачами
func (p *PhaticDialogue) getFromTemplate(phrase string) [] string{
	return getAnswer(p.ReplacementTemplate, phrase, isPhraseMatchTemplate, nil)
}

// Отримання відповіді, де відповідь будується у процесі зіставлення шаблона і фрази користувача
func (p *PhaticDialogue) getFromRules(phrase string) []string{
	return getAnswer(p.MatchingRules, phrase, isPhraseMatchTemplate, getAnswerFromRule)
}

// Допоміжна функція отримання відповіді
func getAnswer(dictionaries []Dictionary, phrase string, containsFunc func(template, phrase string) bool,
	constructAnswerFunc func(template, answer, phrase string) string) []string{ 
	var res []string
	for _, d := range dictionaries{
		if containsFunc(d.Template, phrase){
			answer := d.Answer
			if constructAnswerFunc != nil{
				answer = constructAnswerFunc(d.Template, answer, phrase)
			}
			res = append(res, answer)
		}
	}
	return res
}

func getAnswerFromRule(rule string, answer string, phrase string) string{
	regexRule := formatTemplateForRegex(rule)
	r := *regexp.MustCompile(regexRule)
	re := r.FindAllStringSubmatch(phrase, -1)
	replaceCharArray := getSubCharsArray(rule)
	replaceStep := func(replChar string, i int) {
		if replaceCharArray[0] == replChar {
			if strings.Contains(answer, replChar) {
				answer = strings.Replace(answer, replChar, re[0][i], 1)
				replaceCharArray = replaceCharArray[1:]
			}
		}
	}
 	for i := 1; strings.Contains(answer, "?") || strings.Contains(answer, "*"); i++{
 		if len(replaceCharArray) == 0{
 			break
		}
		replaceStep("?", i)
		replaceStep("*", i)
	}
	return strings.ReplaceAll(answer, "%", "?")
}

func getSubCharsArray(rule string)[]string{
	r := regexp.MustCompile(`[^?\s*]`)
	return strings.Fields(r.ReplaceAllString(rule, ""))
}

func isPhraseMatchTemplate(template string, phrase string, ) bool{
	template = formatTemplateForRegex(template)
	r, _ := regexp.Compile(`^` + template)
	return r.MatchString(phrase)
}

func formatTemplateForRegex(template string) string{
	template = strings.ReplaceAll(template, ` `, `\s`)
	template = strings.ReplaceAll(template, `*`, `(.*)`)
	template = strings.ReplaceAll(template, `?`, `(\w+)`)
	return template
}

func readBytes(dataSource string) ([]byte, error) {
	file, err := os.Open(dataSource)
	if err != nil {
		return []byte{}, err
	}
	bytes, err := ioutil.ReadAll(file)
	if err != nil {
		return []byte{}, err
	}
	return bytes, nil
}

func getRandomString(arr []string) string{
	randomIndex := rand.Intn(len(arr))
	return arr[randomIndex]
}



