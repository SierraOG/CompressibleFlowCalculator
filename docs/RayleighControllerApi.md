# RayleighControllerApi


Method | HTTP request | Description
------------- | ------------- | -------------
[**findRayleighFlowUsingGET**](RayleighControllerApi.md#findRayleighFlowUsingGET) | **GET** /rayleigh/{gamma}/{inputType}/{inputValue} | returns Rayleigh flow properties for given input.


## **findRayleighFlowUsingGET**

returns Rayleigh flow properties for given input.

### Example

 gamma=1.4 inputType=mach inputValue=2
 
 HTTP request:
 
 https://compflow.herokuapp.com/rayleigh/1.4/mach/2
 
 Response Body:
````
{
  "gamma": 1.4,
  "mach": 2,
  "totostar": 0.793388429752066,
  "ttstar": 0.5289256198347108,
  "ppstar": 0.36363636363636365,
  "popostar": 1.5030959785260414,
  "uustar": 1.4545454545454546,
  "sstarsr": 1.217575206151263
}
````

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gamma** | **float** | The value of gamma, the ratio of specific heats. For air, gamma = 1.4 at standard conditions. |
 **inputType** | **string** | Describes the value passed to base the calculations on. Currently only an inputType of 'mach' is supported for Rayleigh Flow. |
 **inputValue** | **float** | The actual value passed to base the calculations on. Currently can only be the mach number for Rayleigh Flow. |

### Return type

[**Rayleigh**](Rayleigh.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

