# HWaaS API Emulator V1

The HWaaS Emulator was built to mimic mock responses from the XCC Z51 chip and the data chip from the DM/DE series. 

The current Swagger documentation (work in progress) can be viewed [here](https://hwaas-emulator.herokuapp.com/swagger-ui.html/).

For live JSON examples pulled from the real chip paths they are currently saved in the "live_json_examples" directory in this project for referencing.

Regarding the End Point Names:
* All existing end point paths are built to mimic the real paths as they exist on the chips, which is why they are as verbose as they are.

Regarding the Class & Model Naming Methodology:
* All classes are built to mimic the paths as they exist on the chips, which is why they are as verbose as they are.

For additional information please reference: 
* [The Project's Gitlab Repository](http://gitlab.xpaas.lenovo.com/dcg-hwaas/xccapiemulator)
* [The Project's Confluence Article](https://km.xpaas.lenovo.com/display/XMDC/HWaaS+API+Emulator)

TODO Feature List:
* Incorporate Basic Auth validation that mimics the validation on the real chips.
* Incorporate randomized errors and the corresponding HTTP Status Code responses.
* Incorporate randomized selection of timezone and UTC for responses.
* Make BigInt scenarios work properly, with less errors.
* Refine Swagger Documentation so it's easier to read and properly lists valid metering methods and responses.
* Incorporate all live json examples into corresponding project directory.
* Incorporate randomized generation of items like serial numbers, model names, etc.
* Gather information from hardware documentation on what the actual upper bounds for data generated should be.
* Create a directory to house Postman/Insomnia export data and upload a complete list to it for easier local use via REST clients.

Way-Down-The-Line TODO Feature List:
* Incorporate database tables to save/load Emulator settings at an individual developer level (such as for desired fail rates, set upper/minimum bounds on metrics, etc).