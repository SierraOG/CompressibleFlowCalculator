# IsentropicControllerApi

Method | HTTP request | Description
------------- | ------------- | -------------
[**findIsentropicFlowUsingGET**](IsentropicControllerApi.md#findIsentropicFlowUsingGET) | **GET** /isentropic/{gamma}/{inputType}/{inputValue} | Returns Isentropic flow properties for given input.


## **findIsentropicFlowUsingGET**

Returns Isentropic flow properties for given input.

### Example

 gamma=1.4 inputType=machangle inputValue=15
 
 HTTP request:
 
 https://compflow.herokuapp.com/isentropic/1.4/machangle/20
 
 Response Body:
````
{
  "gamma": 1.4,
  "mach": 2.923804400162903,
  "machangle": 20,
  "pmangle": 48.26546996744986,
  "ppo": 0.03053239919859204,
  "rhorhoo": 0.08273444920438085,
  "tto": 0.3690409435514237,
  "ppstar": 0.057795668729239164,
  "rhorhostar": 0.13050870944257364,
  "ttstar": 0.4428491322617084,
  "aastar": 3.9380777890650247
}
````

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gamma** | **float** | The value of gamma, the ratio of specific heats. For air, gamma = 1.4 at standard conditions. |
 **inputType** | **string** | Describes the inputValue passed to base the calculations on. Can be 'mach' for Mach number, 'temp' for T/T0 temperature ratio, 'pres' for P/P0 pressure ratio, 'rho' for rho/rho0 density ratio, 'areasub' for A/A* area ratio with the subsonic solution, 'areasuper' for A/A* area ratio with supersonic solution, 'pmangle' for Prandtl-Meyer angle in degrees, or 'machangle' for the Mach angle in degrees |
 **inputValue** | **float** | The corresponding value to do calculations on |

### Return type

[**Isentropic**](Isentropic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

