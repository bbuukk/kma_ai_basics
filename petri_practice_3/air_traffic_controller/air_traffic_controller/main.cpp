

#include <windows.h>
#include <stdio.h>
#include <tchar.h>
#include <iostream>

void start_reqs_screen();

#include "controller.h"
#include "request.h"

int main(void) {

	Controller controller;

	controller.process();
 		
	return 0;
}


