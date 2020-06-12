# FannoControllerApi


Method | HTTP request | Description
------------- | ------------- | -------------
[**getFannoFlowUsingGET**](FannoControllerApi.md#getFannoFlowUsingGET) | **GET** /fanno/{gamma}/{inputType}/{inputValue} | Returns Fanno flow properties for given input.


## **getFannoFlowUsingGET**

Returns Fanno flow properties for given input.

### Example

 gamma=1.4 inputType=mach inputValue=2
 
 HTTP request:
 
 https://compflow.herokuapp.com/fanno/1.4/mach/2
 
 Response Body:
````
{
  "gamma": 1.4,
  "mach": 2,
  "ttstar": 0.6666666666666667,
  "ppstar": 0.408248290463863,
  "popostar": 1.6875000000000002,
  "uustar": 1.632993161855452,
  "flstard": 0.3049965025814798,
  "sstarsr": 0.5232481437645479
}
````

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gamma** | **float** | The value of gamma, the ratio of specific heats. For air, gamma = 1.4 at standard conditions. |
 **inputType** | **string** | Describes the value passed to base the calculations on. Currently only an inputType of 'mach' is supported for Fanno Flow. |
 **inputValue** | **float** | The actual value passed to base the calculations on. Currently can only be the mach number for Fanno Flow. |

### Return type

[**Fanno**](Fanno.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

