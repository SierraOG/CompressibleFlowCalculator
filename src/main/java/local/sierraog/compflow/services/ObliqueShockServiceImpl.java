package local.sierraog.compflow.services;

import local.sierraog.compflow.exceptions.IncorrectInputTypeException;
import local.sierraog.compflow.exceptions.InputOutOfBoundsException;
import local.sierraog.compflow.models.ObliqueShock;
import org.springframework.stereotype.Service;

@Service(value = "obliqueShockService")
public class ObliqueShockServiceImpl extends ObliqBaseFunctions {
    @Override
    public ObliqueShock findObliqueFlow(double gamma, double mach, String secondInputType, double secondInputValue){
        ObliqueShock obliqueFlow;
        double mach2;
        double theta;
        double beta;
        double po2po1;
        double p2p1;
        double rho2rho1;
        double t2t1;
        double m1n;
        double m2n;

        if (gamma <= 1.0) {
            throw new InputOutOfBoundsException("Gamma must be greater than 1");
        }

        if (mach <= 0.0){
            throw new InputOutOfBoundsException("Mach number must be greater than 0");
        }

        switch (secondInputType){
            case "mach1n":
                if (secondInputValue <= 1.0 || secondInputValue >= mach){
                    throw new InputOutOfBoundsException("M1n must be between 1 and Mach1");
                }
                beta = Math.asin(secondInputValue/mach);
                theta = theta(mach, beta, gamma);
                break;
            case "thetaweak":
                theta = secondInputValue*3.14159265359/180.0;
                if (theta >= 3.14159265359/2.0 || theta <= 0.0){
                    throw new InputOutOfBoundsException("Turning angle theta must be between 0 and pi/2");
                }
                beta = beta(mach, theta, gamma, "weak");
                break;
            case "thetastrong":
                theta = secondInputValue*3.14159265359/180.0;
                if (theta >= 3.14159265359/2.0 || theta <= 0.0){
                    throw new InputOutOfBoundsException("Turning angle theta must be between 0 and 90 degrees");
                }
                beta = beta(mach, theta, gamma, "strong");
                break;
            case "beta":
                beta = secondInputValue*3.14159265359/180.0;
                if (beta >= 3.14159265359/2.0){
                    throw new InputOutOfBoundsException("Wave angle beta must be less than 90 degrees");
                }
                else if (beta - Math.asin(1.0/mach) <= 0.0){
                    throw new InputOutOfBoundsException("Wave angle beta must be greater than Mach angle");
                }
                theta = theta(mach, beta, gamma);
                break;
            default:
                throw new IncorrectInputTypeException();
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
