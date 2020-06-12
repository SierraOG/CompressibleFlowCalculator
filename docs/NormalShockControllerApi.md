# NormalShockControllerApi


Method | HTTP request | Description
------------- | ------------- | -------------
[**findNormalShockUsingGET**](NormalShockControllerApi.md#findNormalShockUsingGET) | **GET** /normalshock/{gamma}/{inputType}/{inputValue} | Returns Normal Shock flow properties for given input.


## **findNormalShockUsingGET**

Returns Normal Shock flow properties for given input.

### Example

gamma=1.4 inputType=mach2 inputValue=0.7

 HTTP request:
 
 https://compflow.herokuapp.com/normalshock/1.4/mach2/0.7
 
 Response Body:
````
{
  "gamma": 1.4,
  "mach": 1.5030832509409648,
  "mach2": 0.6999999999999998,
  "po2po1": 0.9288062030184163,
  "p1po2": 0.29197578370172583,
  "p2p1": 2.469135802469136,
  "rho2rho1": 1.8673469387755106,
  "t2t1": 1.3222694461310127
}
````


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gamma** | **float** | The value of gamma, the ratio of specific heats. For air, gamma = 1.4 at standard conditions. |
 **inputType** | **string** | Describes the inputValue passed to base the calculations on. Can be 'mach' for incoming Mach number before the shock wave, 'mach2' for Mach number after the shock wave, 'temp' for T2/T1 temperature ratio, 'pres' for P2/P1 pressure ratio, 'rho' for rho2/rho1 density ratio, 'stagpres' for P02/P01 stagnation pressure ratio, 'presstagpres' for P1/P02 pressure to stagnation pressure ratio |
 **inputValue** | **float** | The corresponding value to do calculations on |

### Return type

[**NormalShock**](NormalShock.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

