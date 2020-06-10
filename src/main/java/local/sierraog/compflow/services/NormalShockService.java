package local.sierraog.compflow.services;

import local.sierraog.compflow.models.Input;
import local.sierraog.compflow.models.NormalShock;

public interface NormalShockService {
    NormalShock findNormalFlow(Input input);
}
