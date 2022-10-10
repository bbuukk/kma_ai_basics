package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"phatic-dialogue/pkg"
	"strings"
)

func main(){
	phatic, err := pkg.NewPhaticDialogue()
	if err != nil{
		log.Fatalln(err)
	}
	reader := bufio.NewReader(os.Stdin)
	for ;; {
		text, _ := reader.ReadString('\n')
		fmt.Println(phatic.GetAnswer(strings.TrimSuffix(text, "\n")))
	}
}