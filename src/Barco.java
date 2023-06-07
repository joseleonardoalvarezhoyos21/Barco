import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Barco {
	private String nombre;
	private String tipo;
	private String id;
	private int modelo; 
	private String color; 
	private String combustible;
	
	
	public Barco() {
		 nombre="No le gusta ponerle nombre a los barcos :(";
		
	}
	
	public Barco(String nombre, String tipo, String id, int modelo, String color,String combustible) {
		this.nombre= nombre;
		this.tipo=tipo;
		this.id=id;
		this.modelo=modelo;
		this.color=color;
		this.combustible=combustible;
	}
	 public void mostrarInformacion() {
	        JOptionPane.showMessageDialog(null, "------------Información de la mascota----------\n\n" 
	                +"ID: " + id + "\n" 
	                +"Nombre: " + nombre + "\n" 
	                +"Tipo: " + tipo + "\n" 
	                +"Modelo: " + modelo + " \n"
	                +"Color: " + color +"\n");
	        sonido();
	        combustible();
	        movimiento();
	        if(combustible.equalsIgnoreCase("si")) {
	        String detener=JOptionPane.showInputDialog("Decea detener el barco: si / no");
	        detener(detener);
	        }else {
	        	JOptionPane.showMessageDialog(null, "Seguimos detenidos por falta de combustible");
	        }
	    }

	private void sonido() {
		if(tipo.equalsIgnoreCase("yate")) {
			JOptionPane.showMessageDialog(null, "Dummmmmm Suena para sarpar");
			
		}else if(tipo.equalsIgnoreCase("barco")) {
			JOptionPane.showMessageDialog(null, "Dummmmmm Suena para sarpar");
		}else {
			JOptionPane.showMessageDialog(null, "No se encuentra registrado el sonido de este vehiculo");
		}	
	}
	
	private void combustible(){
		if(combustible.equalsIgnoreCase("si")) {
			JOptionPane.showMessageDialog(null, "Tanque full, listo para sarpar");
		}else {
			JOptionPane.showMessageDialog(null, "Tanque vacío, llenar tanque");
		}
	}
	private void movimiento() {
		if(combustible.equalsIgnoreCase("si")) {
			JOptionPane.showMessageDialog(null, "El: " + tipo + " va adelante");
		}else {
			JOptionPane.showMessageDialog(null, "El: " + tipo + " sigue detenido");
		}
	}
	
	private void detener(String detener) {
		if(detener.equalsIgnoreCase("si")) {
			JOptionPane.showMessageDialog(null, "El: " + tipo + "Se esta deteniendo");
		}else {
			JOptionPane.showMessageDialog(null, "El: " + tipo + "Sigue en movimiento");
		}
		
	}
	public void ingresarDatos() {
		nombre= JOptionPane.showInputDialog("Ingrese el nombre del barco: ");
		tipo=JOptionPane.showInputDialog("Ingrese el tipo del barco: ");
		id=JOptionPane.showInputDialog("Ingrese la id del barco");
		modelo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el modelo del barco"));
		color =JOptionPane.showInputDialog("Ingrese el color del barco");
		combustible=JOptionPane.showInputDialog("El " + tipo + "tiene combustible si o no:");
	}
	
	public static void main(String[]args) {
	ArrayList<Barco> listaBarcos = new ArrayList<>();
    HashMap<String, Barco> mapaBarco = new HashMap<>();
    int opcion;
    String menu = "";
    do {
        menu = "MENÚ\n";
        menu += "1. Crear un Barco\n";
        menu += "2. Ver información de Barcos\n";
        menu += "3. Ver lista de Barcos\n";
        menu += "4. Modificar un Barco\n";
        menu += "5. Salir\n";
        menu += "Ingresa una opción:\n ";

        opcion =Integer.parseInt(JOptionPane.showInputDialog(menu));

        switch (opcion) {
            case 1:
                Barco barco = new Barco();
                barco.ingresarDatos();
                listaBarcos.add(barco);
                mapaBarco.put(barco.getBarcoId(), barco);
                break;
            case 2:
                String idBarco = JOptionPane.showInputDialog("Ingresa del Barco a buscar ");
                if (mapaBarco.containsKey(idBarco)) {
                    Barco barcoVisualizar = mapaBarco.get(idBarco);
                    barcoVisualizar.mostrarInformacion();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningun barco con el ID ingresado.");
                }
                break;
            case 3:
                String informacionBarco = "Lista de Barcos:\n";
                for (Barco barcoEnLista : listaBarcos) {
                	informacionBarco += "ID: " + barcoEnLista.getBarcoId() + ", Nombre: " + barcoEnLista.getBarcoNombre() + "\n";
                }
                JOptionPane.showMessageDialog(null, informacionBarco);
                break;
            case 4:
                idBarco = JOptionPane.showInputDialog("Ingresa el ID del Barco a modificar: ");
                if (mapaBarco.containsKey(idBarco)) {
                    Barco mascotaAModificar = mapaBarco.get(idBarco);
                    mascotaAModificar.ingresarDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningun Barco con el ID ingresado.");
                }
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, intenta nuevamente.");
        }
    } while (opcion != 5);
	
	}

	public String getBarcoNombre() {
		return nombre;
	}
	
	public void setBarcoNombre(String nombre) {
		this.nombre=nombre;
	}

	public String getBarcoId() {
		return id;
	}
	
	public void setId(String id) {
		this.id= id;
	}
	
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo=modelo;
	} 
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	
	public String getCombustible(String combustible) {
		return combustible;
	}
	
	public void setCombustible(String combustible) {
		this.combustible=combustible;
	}
}
