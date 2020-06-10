package local.sierraog.compflow.services;

import local.sierraog.compflow.models.Input;
import local.sierraog.compflow.models.Isentropic;

public interface IsentropicService {
    Isentropic findIsentropicFlow(Input input);
}
