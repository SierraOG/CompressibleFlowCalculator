package local.sierraog.compflow.services;

import local.sierraog.compflow.models.ObliqueShock;

public interface ObliqueShockService {
    ObliqueShock findObliqueFlow(double gamma, double mach, String secondInputType, double secondInputValue);
}
