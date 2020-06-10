package local.sierraog.compflow.services;

import local.sierraog.compflow.models.ObliqueShock;
import local.sierraog.compflow.models.TwoInputs;
import org.springframework.stereotype.Service;

@Service(value = "obliqueShockService")
public class ObliqueShockServiceImpl extends ObliqBaseFunctions {
    @Override
    public ObliqueShock findObliqueFlow(TwoInputs input){
        ObliqueShock obliqueFlow;
        double gamma = input.getGamma();
        double mach = input.getMach();
        double mach2;
        double theta;
        double beta;
        double po2po1;
        double p2p1;
        double rho2rho1;
        double t2t1;
        double m1n;
        double m2n;

        switch (input.getSecondInputType()){
            case "mach1n":
                beta = Math.asin(input.getSecondInputValue()/mach);
                theta = theta(mach, beta, gamma);
                break;
            case "thetaweak":
                theta = input.getSecondInputValue()*3.14159265359/180.0;
                beta = beta(mach, theta, gamma, "weak");
                break;
            case "thetastrong":
                theta = input.getSecondInputValue()*3.14159265359/180.0;
                beta = beta(mach, theta, gamma, "strong");
                break;
            case "beta":
                beta = input.getSecondInputValue()*3.14159265359/180.0;
                theta = theta(mach, beta, gamma);
                break;
            default:
                theta = 0;
                beta = 90*3.14159265359/180.0;
        }
        m1n = mach*Math.sin(beta);
        m2n = mach2(m1n, gamma);
        mach2 = m2n/Math.sin(beta - theta);
        beta = beta*180.0/3.14159265359;
        theta = theta*180.0/3.14159265359;
        p2p1 = 1.0 + 2.0*gamma/(gamma+1.0)*(m1n*m1n - 1.0);
        po2po1 = ppo(m1n, gamma)/ppo(m2n, gamma)*p2p1;
        rho2rho1 = rro(m2n, gamma)/rro(m1n, gamma)*po2po1;
        t2t1 = tto(m2n, gamma)/tto(m1n, gamma);
        obliqueFlow = new ObliqueShock(gamma, mach, mach2, theta, beta, po2po1, p2p1, rho2rho1, t2t1, m1n, m2n);
        return obliqueFlow;
    }
}
