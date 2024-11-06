package misterio;

public class Persona {

    private int salario;
    private int conocimiento;
    private double svc;

    public Persona(int salario, int conocimiento) {
        this.salario = salario;
        this.conocimiento = conocimiento;
        this.svc= ((double)conocimiento / (double) salario);
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getConocimiento() {
        return conocimiento;
    }

    public void setConocimiento(int conocimiento) {
        this.conocimiento = conocimiento;
    }

    public double getSvc() {
        return svc;
    }

    public void setSvc(double svc) {
        this.svc = svc;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "salario=" + salario +
                ", conocimiento=" + conocimiento +
                ", svc=" + svc +
                '}';
    }
}
