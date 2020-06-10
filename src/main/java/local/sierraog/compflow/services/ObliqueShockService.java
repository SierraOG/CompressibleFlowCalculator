package local.sierraog.compflow.services;

import local.sierraog.compflow.models.ObliqueShock;
import local.sierraog.compflow.models.TwoInputs;

public interface ObliqueShockService {
    ObliqueShock findObliqueFlow(TwoInputs input);
}
