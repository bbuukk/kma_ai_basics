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

    void process();

    void denial(const Request& req);
    void approval(const Request& req);

    inline const std::string& name() const { return name_; };
    inline const std::string& runaway() const { return runway_; };
    inline const bool is_rw_free() const { return is_rw_free_; };

private:

    /*std::vector<std::string> seq;*/
    std::string name_ = "Tower Kyiv";
    std::string runway_ = "runway45";
    bool is_rw_free_ = true;

};


