# CompressibleFlowCalculator
Java REST API for compressible flow calculations. Endpoints available for Isentropic Flow Relations, Normal Shock Relations, Oblique Shock Relations, Fanno Flow, and Rayleigh Flow. Relations are from standard aerodynamic equations. 

## Documentation for API Endpoints

Base URL: https://compflow.herokuapp.com

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*FannoControllerApi* | [**getFannoFlowUsingGET**](docs/FannoControllerApi.md#getfannoflowusingget) | **GET** /fanno/{gamma}/{inputType}/{inputValue} | Returns Fanno flow properties for given input.
*IsentropicControllerApi* | [**findIsentropicFlowUsingGET**](docs/IsentropicControllerApi.md#findisentropicflowusingget) | **GET** /isentropic/{gamma}/{inputType}/{inputValue} | Returns Isentropic flow properties for given input.
*NormalShockControllerApi* | [**findNormalShockUsingGET**](docs/NormalShockControllerApi.md#findnormalshockusingget) | **GET** /normalshock/{gamma}/{inputType}/{inputValue} | Returns Normal Shock flow properties for given input.
*ObliqueShockControllerApi* | [**findOliqueFlowUsingGET**](docs/ObliqueShockControllerApi.md#findoliqueflowusingget) | **GET** /oblique/{gamma}/{mach}/{secondInputType}/{secondInputValue} | Returns Oblique Shock flow properties for given inputs.
*RayleighControllerApi* | [**findRayleighFlowUsingGET**](docs/RayleighControllerApi.md#findrayleighflowusingget) | **GET** /rayleigh/{gamma}/{inputType}/{inputValue} | returns Rayleigh flow properties for given input.


## Documentation For Models

 - [Fanno](docs/Fanno.md)
 - [Isentropic](docs/Isentropic.md)
 - [NormalShock](docs/NormalShock.md)
 - [ObliqueShock](docs/ObliqueShock.md)
 - [Rayleigh](docs/Rayleigh.md)


## Documentation For Authorization

 All endpoints do not require authorization.

