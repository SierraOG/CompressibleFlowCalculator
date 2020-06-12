package local.sierraog.compflow.services;

import local.sierraog.compflow.models.Isentropic;

public interface IsentropicService {
    Isentropic findIsentropicFlow(double gamma, String inputType, double inputValue);
}
