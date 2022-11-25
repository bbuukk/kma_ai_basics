#pragma once


#include <fstream>
#include <iostream>
#include <sstream>
#include <chrono>
#include <ctime>    
#include <random>

#include <iomanip>
#include <string>

#include "request.h"

Request::Request(
    std::string iaco,
    std::string call_sign,
    std::string origin,
    std::string destination,
    std::string altitude,
    std::string status)
    : airlane_iaco_(iaco),
      call_sign_(call_sign_),
      origin_(origin_),
      destination_(destination),
      altitude_(altitude_),
      status_(status_) {};

int Request::gen_tol_time() {
    return gen_rand_num(5, 10);
};

int gen_rand_num(int from, int to) {
    std::random_device rd; // obtain a random number from hardware
    std::mt19937 gen(rd()); // seed the generator
    std::uniform_int_distribution<> distr(from, to); // define the range

    return distr(gen);
}

Request& Request::get_request(std::ifstream& file) {

	std::string line;

    /*while (true) {
        if (std::getline(file, line)) {
            break;
        }
        else {
            continue;
        }
    }*/

    while (!std::getline(file, line)) {}

	/*std::vector<std::string> fields;*/
    std::vector<std::string> fields;
	std::istringstream iss(line);
	while (std::getline(iss, line, ';')) {
		fields.push_back(line);
	}

    Request* req = new Request(
        fields[0], fields[1],
        fields[2], fields[3],
        fields[4], fields[5]);

    return *(req);
}