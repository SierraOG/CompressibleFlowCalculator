package local.sierraog.compflow.services;

import local.sierraog.compflow.models.Fanno;
import local.sierraog.compflow.models.Input;

public interface FannoService {
    Fanno findFannoFlow(Input input);
}
