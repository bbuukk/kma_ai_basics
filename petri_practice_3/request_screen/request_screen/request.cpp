#pragma once

#include "request.h"

#include <iostream>
#include <sstream>
#include <chrono>
#include <ctime>    
#include <random>

#include <iomanip>
#include <string>

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
                fields[4], "MSB",
                std::to_string(count_attitude()),
                "landing"));
    }
    file.close();

    return (*requests);
};

int Request::count_attitude() {
    return gen_rand_num(100,250);
};

int gen_rand_num(int from, int to) {
    std::random_device rd; // obtain a random number from hardware
    std::mt19937 gen(rd()); // seed the generator
    std::uniform_int_distribution<> distr(from, to); // define the range

    return distr(gen);
}

void write_to_csv(const Request& req, std::ofstream& file) {
    file
        << req.airlane_iaco() << ';'
        << req.call_sign() << ';'
        << req.origin() << ';'
        << req.destination() << ';'
        << req.altitude() << ';'
        << req.status() << '\n' << std::flush;
}

std::ostream& operator<<(std::ostream& os, const Request& req) {
    return os
        << std::left
        << faint << "|iaco|-------call sign-------|orig|dest|altt|---status---|" << reset << "\n"
        << "|" << underline << l_yellow << std::setw(4) << req.airlane_iaco() << reset
        << "|" << underline << red << std::setw(23) << req.call_sign() << reset
        << "|" << underline << blue << std::setw(4) << req.origin() << reset
        << "|" << underline << blue << std::setw(4) << req.destination() << reset
        << "|" << underline << yellow << std::setw(4) << req.altitude() << reset
        << "|" << underline << green << std::setw(12) << req.status() << reset << '|';
}

