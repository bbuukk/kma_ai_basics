#pragma once

#include "request.h"

#include <iostream>
#include <sstream>
#include <chrono>
#include <ctime>    
#include <random>

Request::Request(
    std::string iaco,
    std::string call_sign,
    std::string origin,
    int altitude,
    std::string status)
    : airlane_iaco(iaco),
      call_sign(call_sign),
      origin(origin),
      destination("MSB"),
      altitude(altitude),
      status(status) {};

std::vector<Request>& Request::get_requests() {
    std::vector<Request>* requests = new std::vector<Request>;

    std::ifstream file("../t_data/request.csv");
    if (!file) {
        std::cerr << "Could not open file." << std::endl;
    }

    std::string line;
    while (std::getline(file, line))
    {

        std::vector<std::string> fields;
        std::istringstream iss(line);
        while (std::getline(iss, line, ';')) { 
            fields.push_back(line);
        }

        (*requests).push_back(
            Request(
                fields[0], fields[2],
                fields[4], count_attitude(),
                "landing"));
          
    }
    file.close();

    return (* requests);
};

int Request::count_attitude() {
    
    std::random_device rd; // obtain a random number from hardware
    std::mt19937 gen(rd()); // seed the generator
    std::uniform_int_distribution<> distr(100, 250); // define the range

    return distr(gen);    
};

std::ostream& operator<<(std::ostream& os, const Request& request) {
    return os
        << "============Landing request============" << "\n"
        << "Airlane iaco: " << request.get_airlane_iaco() << "\n"
        << "Call sign:    " << request.get_call_sign() << "\n"
        << "Origin:       " << request.get_origin() << "\n"
        << "Destination:  " << request.get_destination() << "\n"
        << "Altitude:     " << request.get_altitude() << "\n"
        << "Status:       " << request.get_status() << "\n"
        << "=======================================" << "\n";

}

