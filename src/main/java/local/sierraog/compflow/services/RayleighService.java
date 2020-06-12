package local.sierraog.compflow.services;

import local.sierraog.compflow.models.Rayleigh;

public interface RayleighService {
    Rayleigh findRayleighFlow(double gamma, String inputType, double inputValue);
}
