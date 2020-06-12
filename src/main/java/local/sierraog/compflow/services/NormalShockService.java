package local.sierraog.compflow.services;

import local.sierraog.compflow.models.NormalShock;

public interface NormalShockService {
    NormalShock findNormalFlow(double gamma, String inputType, double inputValue);
}
