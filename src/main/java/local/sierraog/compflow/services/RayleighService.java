package local.sierraog.compflow.services;

import local.sierraog.compflow.models.Input;
import local.sierraog.compflow.models.Rayleigh;

public interface RayleighService {
    Rayleigh findRayleighFlow(Input input);
}
