#pragma once
//#define NDEBUG

#include <string>
#include <iostream>
#include <fstream> 
#include <vector>


static constexpr char red[]("\033[38;2;255;0;0m");
static constexpr char green[]("\033[38;2;50;205;50m");

static constexpr char yellow[]("\033[38;2;255;255;204m");
static constexpr char l_yellow[]("\033[38;2;255;255;153m");

static constexpr char blue[]("\033[38;2;176;224;230m");

//static constexpr char rgb[]("\033[38;2;");

static const char faint[]{ 0x1B,'[','2','m','\0' };
static const char underline[]{ 0x1B,'[','4','m','\0' };
static const char italics[]{ 0x1B,'[','3','m','\0' };
static const char bold[]{ 0x1B,'[','1','m','\0' };
static const char reset[]{ 0x1B,'[','0','m','\0' };

class Request {

public:
    Request(
        std::string iaco,
        std::string call_sign,
        std::string origin,
        std::string destination,
        std::string altitute,
        std::string status);

    Request(void) = default;
    ~Request() = default;

    Request(const Request&) = default;
    Request& operator=(const Request&) = default;

    Request& operator=(Request&&) noexcept = default;
    Request(Request&&) noexcept = default;

    static Request& get_request(std::ifstream& file);
    static std::string& read_request(std::ifstream& file);
    static std::vector<std::string>& parse_request(std::string& request);
    int gen_tol_time();

    inline const std::string& airlane_iaco() const { return airlane_iaco_; };
    inline const std::string& call_sign() const { return call_sign_; };

    inline const std::string& origin() const { return origin_; };
    inline const std::string& destination() const { return destination_; };

    inline const std::string& altitude() const { return altitude_; };
    inline const std::string& status() const { return status_; };

private:
    static int count_attitude();

    std::string airlane_iaco_;
    std::string call_sign_;
    
    std::string origin_;
    std::string destination_;

    //std::string time;
    std::string altitude_;
    std::string status_;

};

int gen_rand_num(int from, int to);

std::ostream& operator<<(std::ostream&, const Request&);

