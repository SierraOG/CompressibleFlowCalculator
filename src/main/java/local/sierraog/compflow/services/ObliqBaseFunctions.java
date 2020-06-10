package local.sierraog.compflow.services;

abstract class ObliqBaseFunctions implements ObliqueShockService {
    public double mach2(double mach1, double gamma){
        return Math.sqrt((1.0 + 0.5 * (gamma - 1.0) * mach1 * mach1) / (gamma * mach1 * mach1 - 0.5 * (gamma - 1.0)));
    }
    public double tto(double mach, double gamma){
        return Math.pow((1.0+(gamma-1.0)/2.0*mach*mach),-1.0);
    }
    public double ppo(double mach, double gamma){
        return Math.pow((1.0+(gamma-1.0)/2.0*mach*mach),-gamma/(gamma-1.0));
    }
    public double rro(double mach, double gamma){
        return Math.pow((1.0+(gamma-1.0)/2.0*mach*mach),-1.0/(gamma-1.0));
    }
    public double theta(double mach1, double beta, double gamma){
        return Math.atan((mach1*mach1*Math.sin(2.0*beta)-2.0/Math.tan(beta))/(2.0+mach1*mach1*(gamma+Math.cos(2.0*beta))));
    }
    public double beta(double mach1, double theta, double gamma, String type){
        double p=-(mach1*mach1+2.)/mach1/mach1-gamma*Math.sin(theta)*Math.sin(theta);
        double q=(2.*mach1*mach1+1.)/Math.pow(mach1,4.)+((gamma+1.)*(gamma+1.)/4.+(gamma-1.)/mach1/mach1)*Math.sin(theta)*Math.sin(theta);
        double r=-Math.cos(theta)*Math.cos(theta)/Math.pow(mach1,4.);

        double a=(3.*q-p*p)/3.;
        double b=(2.*p*p*p-9.*p*q+27.*r)/27.;

        double test=b*b/4.+a*a*a/27.;

        if(test>0.0) {return -1.0;}
        else {
            double x1 = 0.0;
            double x2 = 0.0;
            double x3 = 0.0;

            if(test==0.0) {
                x1=Math.sqrt(-a/3.);
                x2=x1;
                x3=2.*x1;
                if(b>0.0) {
                    x1*=-1.0;
                    x2*=-1.0;
                    x3*=-1.0;
                }
            }
            if(test<0.0) {
                double phi=Math.acos(Math.sqrt(-27.*b*b/4./a/a/a));
                x1=2.*Math.sqrt(-a/3.)*Math.cos(phi/3.);
                x2=2.*Math.sqrt(-a/3.)*Math.cos(phi/3.+3.14159265359*2./3.);
                x3=2.*Math.sqrt(-a/3.)*Math.cos(phi/3.+3.14159265359*4./3.);
                if(b>0.0) {
                    x1*=-1.0;
                    x2*=-1.0;
                    x3*=-1.0;
                }
            }

            double s1=x1-p/3.0;
            double s2=x2-p/3.0;
            double s3=x3-p/3.0;

            double t1;
            double t2;
            if(s1<s2 && s1<s3) {
                t1=s2;
                t2=s3;
            }
            else if(s2<s1 && s2<s3) {
                t1=s1;
                t2=s3;
            }
            else {
                t1=s1;
                t2=s2;
            }

            double b1=Math.asin(Math.sqrt(t1));
            double b2=Math.asin(Math.sqrt(t2));

            double betas=b1;
            double betaw=b2;
            if(b2>b1) {
                betas=b2;
                betaw=b1;
            }

            if(type == "strong") {return betas;}
            else {return betaw;}}
    }
}
