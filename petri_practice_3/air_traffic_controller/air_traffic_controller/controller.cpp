#pragma once

#include "controller.h"

#include <iostream>

void Controller::process(const Request& req) {

	std::string call_sign = req.get_call_sign();

	std::cout << req << "\n";
	std::string request = "Tower Kyiv," + call_sign + "asking for landing permission";

	if (is_runaway_free) {
		std::cout << call_sign + ", roger" << "\n";
		std::cout << call_sign + " you are clear to land, " + runway << "\n";
		
	}
	else {
		std::cout << call_sign + ", roger" << "\n";
		/*std::cout << call_sign + " negative, copy?" + runway << "\n";*/
		
		std::cout << call_sign + " you are clear to land, " + runway + ", number " + std::to_string(seq.size()) << "\n";

	}
}

//reback instructions to controller
//in sequence
//pilot say: "WILCO" - will comply
//pilot say: "ROGER" - received all transmission
//pilot say: "affirmative" or "negative" - to say "yes" or "no"
//pilot say: "LINE UP AND WAIT" - go to runway and wait for next instructions
//pilot say: traffic calls & proper responses 12:00 ahead, 6:00 below
	// "traffic in sight" if you see traffic
	// "negative contact"
//landing sequence
	// november67889, you'r clear to land, runway37, number 4
//proper takeoff call 
	//tower, november67889 --
//exit at the runaway
	//contact ground 
	//monitor ground //ground controllers will call you
	//stay with me, not change to ground controler frequence, but stay with tower controller after landing
	//contacg ground .6 , means to contact ground controller and saying partially frequency
//resume own nav, resume pilot's navigation responsibilities, ATC is out of these responsibilities
// "hold short", don't go 
// "squawk vfr", change
//

//“Cleared for the ILS, runway three four”(follow the Instrument Landing System, an electronic guidance system, to runway 34)
//“Cleared for the visual, runway one seven”(look out the window, find runway 17, and fly to it)
//“Cleared to land, runway two seven Right”(The pilot has permission to land on Runway 27 Right)
