#pragma once

#include <string>
#include <iostream>
#include <fstream> 
#include <vector>

class Request {

public:
    Request(
        std::string iaco,
        std::string call_sign,
        std::string origin,
        int altitude,
        std::string status);

    Request(void) = default;
    ~Request() = default;

    Request(const Request&) = default;
    Request& operator=(const Request&) = default;

    Request& operator=(Request&&) noexcept = default;
    Request(Request&&) noexcept = default;

    static std::vector<Request>& get_requests();

    inline const std::string& get_airlane_iaco() const { return airlane_iaco; };
    inline const std::string& get_call_sign() const { return call_sign; };

    inline const std::string& get_origin() const { return origin; };
    inline const std::string& get_destination() const { return destination; };

    inline const int get_altitude() const { return altitude; };
    inline const std::string& get_status() const { return status; };

private:
    static int count_attitude();

    std::string airlane_iaco;
    std::string call_sign;
    
    std::string origin;
    std::string destination;

    //std::string time;
    int altitude;
    std::string status;

};

std::ostream& operator<<(std::ostream&, const Request&);

