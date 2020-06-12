package local.sierraog.compflow.services;

import local.sierraog.compflow.models.Fanno;

public interface FannoService {
    Fanno findFannoFlow(double gamma, String inputType, double inputValue);
}
