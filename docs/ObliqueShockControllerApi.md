# ObliqueShockControllerApi


Method | HTTP request | Description
------------- | ------------- | -------------
[**findOliqueFlowUsingGET**](ObliqueShockControllerApi.md#findOliqueFlowUsingGET) | **GET** /oblique/{gamma}/{mach}/{secondInputType}/{secondInputValue} | Returns Oblique Shock flow properties for given inputs.


## **findOliqueFlowUsingGET**

Returns Oblique Shock flow properties for given inputs.

### Example

 gamma=1.4 mach=2 secondInputType=thetaweak secondInputValue=20

 HTTP request:
 
 https://compflow.herokuapp.com/oblique/1.4/2/thetaweak/20
 
Response Body:
````
{
  "gamma": 1.4,
  "mach": 2,
  "mach2": 1.210218400827072,
  "theta": 20,
  "beta": 53.42294052721989,
  "po2po1": 0.8929139852894127,
  "p2p1": 2.84286270503575,
  "rho2rho1": 2.0420057206057796,
  "t2t1": 1.392191352036168,
  "m1n": 1.6061122639206629,
  "m2n": 0.6666063985843536
}
````

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gamma** | **float** | The value of gamma, the ratio of specific heats. For air, gamma = 1.4 at standard conditions. |
 **mach** | **float** | The incoming Mach number before the shock. |
 **secondInputType** | **string** | Describes the secondInputValue passed to base the calculations on. Can be 'mach1n' for the normal component for the incoming Mach number, 'beta' for the shock wave angle beta in degrees, 'thetaweak' for the turn angle theta in degrees assuming a weak shock solution, or 'thetastrong' for the turn angle theta in degrees assuming a strong shock solution |
 **secondInputValue** | **float** | The corresponding input value. |

### Return type

[**ObliqueShock**](ObliqueShock.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

