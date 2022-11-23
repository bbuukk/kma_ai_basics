#pragma once

#pragma once

#include <string>
#include <iostream>
#include <fstream> 
#include <vector>
#include "request.h"

class Controller {

public:
    Controller(void) = default;
    virtual ~Controller() = default;

    void process(const Request&);
    
    //
    //inline const std::string& get_country() const { return country; };
    //inline const std::string& get_airport_code() const { return airport_code; };

private:

    std::vector<std::string> seq;
    
    std::string runway = "runway45";

    bool is_runaway_free = true;

};


