package com.jaimecorg.springprojects.tienda.services;



import com.jaimecorg.springprojects.tienda.model.Empleado;

public interface EmpleadosServices {
    

    public Empleado findEmpleado(int codigo);

    public void save(Empleado empleado);
    public void update(Empleado empleado);

    public void delete(int codigo);

    public void insert(Empleado empleado);

    public Empleado findAll(int codigo);
}
