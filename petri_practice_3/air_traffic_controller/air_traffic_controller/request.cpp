#pragma once

#include <fstream>
#include <iostream>
#include <iomanip>
#include <sstream>
#include <string>
#include <chrono>
#include <ctime>    
#include <random>
#include <thread>

#include "request.h"

Request::Request(
    std::string iaco,
    std::string call_sign,
    std::string origin,
    std::string destination,
    std::string altitude,
    std::string status)
    : airlane_iaco_(iaco),
      call_sign_(call_sign),
      origin_(origin),
      destination_(destination),
      altitude_(altitude),
      status_(status) {};

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

    //get not parsed request from file
	std::string line = read_request(file);
    std::vector<std::string> attributes =
        parse_request(line);
	
    Request* req = new Request(
        attributes[0], attributes[1],
        attributes[2], attributes[3],
        attributes[4], attributes[5]);

    return *(req);
}

std::string& Request::read_request(std::ifstream& file) {

    if (file.is_open())
    {
        std::string* line = new std::string;
        while (true)
        {
            if (std::getline(file, (*line)))
                return *line;
            if (!file.eof()) break; // ensure end of read was EOF.
            file.clear();

            //avoiding cpu hogging
            std::this_thread::sleep_for(std::chrono::milliseconds(10));
        }
    }

    /*return std::string("dila ne bude");*/
}

std::vector<std::string>& Request::parse_request(std::string& request) {
    
    std::vector<std::string>* fields = new std::vector<std::string>;
    std::istringstream iss(request);
    while (std::getline(iss, request, ';')) {
        (*fields).push_back(request);
    }
    return *(fields);
}

