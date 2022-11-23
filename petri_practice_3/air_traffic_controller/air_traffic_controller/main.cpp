

#include "controller.h"
#include "request.h"

int main(void) {

	Controller controller;
	std::vector<Request> requests = Request::get_requests();
	/*requests.erase(requests.begin());*/
	
	//for(auto& request : requests)
	//{
	//	controller.process(request);
	//}

	controller.process(requests[0]);
 		
	return 0;
}

