import java.util.Random;
import java.util.Date;
import java.util.Scanner;
import javax.naming.spi.DirStateFactory.Result;
import java.text.SimpleDateFormat;


class Escuela_menu_parcial
  {
 
	static Instituto i1;
    public static void main (String[] args) {

	int i=0, indice_actas=0;
	Inicializa_datos ();
	String s_menu="Menu IFTS 16:\n\n\n"+
						"1- Registros de alumno por DNI \n"+
						"2- Eliminar alumno de todas las actas por DNI\n"+
						"3- Listar descripción de los libros del Instituto\n"+
						"4- Listar actas de los libros del Instituto\n"+
						"5- Eliminar actas de un libro\n"+
						"6- Promedio de un libro\n"+
						"0- Terminar";
	
    System.out.println(s_menu);

	Scanner sc= new Scanner(System.in);
	String i_codigolibro="1", i_dni= "1", i_menu="1";
	Libro libro_temp;
	Acta acta_temp;

	while ( ! i_menu.equals("0")) {
		System.out.println("\nIngrese opcion del menu: ");
		i_menu= sc.nextLine();

		i=0;
		if (i_menu.equals("1"))
			{
			System.out.print("Ingrese DNI: ");
			i_dni= sc.nextLine();
			
			String result="";


			while (i<i1.getCantidad_libros()) {
				libro_temp=i1.getLibro(i);
				indice_actas=0;
				while (indice_actas<libro_temp.getCantidad_actas())
					{
					acta_temp=libro_temp.getActa(indice_actas);
					result+=acta_temp.buscarAlumno(i_dni)+"\n";
					indice_actas++;	
					}
				i++;
				}

		System.out.println("busqueda (dni:"+i_dni+"): \n"+result);
			}

		else if (i_menu.equals("2"))  {
			System.out.println("Elimina registros del alumno todas en las actas");			
			
			System.out.print("Ingrese DNI: ");
			i_dni= sc.nextLine();
			String result="";

			while (i<i1.getCantidad_libros()) {
				libro_temp=i1.getLibro(i);
				indice_actas=0;
				while (indice_actas<libro_temp.getCantidad_actas())
					{
					acta_temp=libro_temp.getActa(indice_actas);
					result+=acta_temp.eliminarAlumno(i_dni)+"\n";

					indice_actas++;	
					}

				i++;
				}
			System.out.println("eliminación (dni:"+i_dni+"): \n"+result);
			}

		else if (i_menu.equals("3")) {
			System.out.println("Muestro la descripción de los libros del instituto");
		    i=0;
			while (i<i1.getCantidad_libros()) {
				libro_temp=i1.getLibro(i);
				System.out.println("Codigo del libro: "+libro_temp.getCodigo_libro()+
							", Ubicacion: "+libro_temp.getUbicacion() + ", cantidad de actas: "+libro_temp.getCantidad_actas());
				i++;
				}
			}

		else if (i_menu.equals("4")) {
			System.out.println("Muestro el contenido de las actas del instituto");
		    i=0;
			while (i<i1.getCantidad_libros()) {
				libro_temp=i1.getLibro(i);
				System.out.println("Codigo del libro: "+libro_temp.getCodigo_libro()+
							", Ubicacion: "+libro_temp.getUbicacion() + ", cantidad de actas: "+libro_temp.getCantidad_actas());
				indice_actas=0;
				while (indice_actas<libro_temp.getCantidad_actas()) {
					acta_temp=libro_temp.getActa(indice_actas);
					System.out.println("listado de alumnos del acta x del libro y:\n"+acta_temp.getListado_alumnos());
					indice_actas++;	
				}
				i++;
			}
		}

		else if (i_menu.equals("5")) {
            System.out.println("Libros del instituto: ");
            i = 0;

            while (i < i1.getCantidad_libros()) {
                libro_temp = i1.getLibro(i);
                System.out.println("Código: " +libro_temp.getCodigo_libro()+", Ubicación: " + libro_temp.getUbicacion() + ", Actas: " + libro_temp.getCantidad_actas());
                i++;
            }
                System.out.print("Ingrese código del Libro: ");
                i_codigolibro = sc.nextLine();
                i = 0;
                int actas = 77;
            while (i < i1.getCantidad_libros()) {
                libro_temp = i1.getLibro(i);
                if (i_codigolibro.equals(libro_temp.getCodigo_libro())) {
                    libro_temp.eliminaActa();
                    actas = libro_temp.getCantidad_actas();
                }
                i++;
            }
                System.out.println("Actas restantes del libro: " + Integer.toString(actas));
		}	
		
		else if(i_menu.equals("6")){
			System.out.println("Obtener promedio de un libro:\n");
                System.out.println("Libros del instituto: ");
                i = 0;
                while (i<i1.getCantidad_libros()) {
                    libro_temp = i1.getLibro(i);
                    System.out.println("Código: "+libro_temp.getCodigo_libro()+", Ubicación: "+libro_temp.getUbicacion()+", Actas: "+libro_temp.getCantidad_actas());
                    i++;
                }
                System.out.print("Ingrese código del Libro: ");
                i_codigolibro = sc.nextLine();
                i = 0;
                int actas = 0;

                while (i<i1.getCantidad_libros()) {
                    libro_temp = i1.getLibro(i);
                    if (i_codigolibro.equals(libro_temp.getCodigo_libro())) {
                        indice_actas = 0;
                        while (indice_actas<libro_temp.getCantidad_actas()) {
                            acta_temp = libro_temp.getActa(indice_actas);
                            actas += Integer.parseInt(acta_temp.getPromedio());
                            indice_actas++;
                        }
                        actas = actas/indice_actas;
                    }
                    i++;
                }
                System.out.println("Promedio del libro "+i_codigolibro +":\n" + Integer.toString(actas));
		}

		else if (i_menu.equals("0"))
			System.out.print("Finalizando app");
		else
			System.out.print("Opcion no reconocida");
		}

			
		System.out.println("\ncorrelatividades paradigmas: "+Materia.paradigmas.getCorrelatividades());	
		System.out.println("correlatividades taller2: "+Materia.taller2.getCorrelatividades());	


    
/*
    while (i<l1.getCantidad_actas()) {
		acta_temp=l1.getActa(i);
		System.out.println("Datos del acta antes de eliminar:\n"+acta_temp.getListado_alumnos());
		System.out.println("Elimina alumno dni: 33444555: "+acta_temp.eliminarAlumno(i_dni));
		System.out.println("Datos del acta después de eliminar:\n"+acta_temp.getListado_alumnos());
		i++;
		}
		promedio_libro=promedio_libro/i;
		System.out.println("Promedio del libro 1:\n"+Integer.toString(promedio_libro));

*/

	} //fin de metodo main




   public static void Inicializa_datos() {

	int i, temp;

	Profe p1;
	Profe p2;
	Profe p3;

	Curso c1;
	Curso c2;
	Curso c3;
	
	Materia_curso mc1;
	Materia_curso mc2;
	Materia_curso mc3;
	Materia_curso mc4;
	Materia_curso mc5;
	Materia_curso mc6;
	Materia_curso mc7;
	Materia_curso mc8;

	Acta a1;
	Acta a2;
	Acta a3;
	Acta a4;
	Acta a5;

	Libro l1;
	Libro l2;
	Libro l3;	 
	 
	 
    p1=new Profe("Benetti", "Juan", "34565434", 34);
    p2=new Profe("Flores", "Rodolfo", "22565434", 44);
    p3=new Profe("Fiorelli", "Brenda", "29565434", 40);

    c1= new Curso();
    c1.setAnio("2022");
    c1.setAnio_curricular("Primero");
    c1.setDivision("B");
	c1.setInstitucion("IFST 16");

    c2= new Curso();
    c2.setAnio("2022");
    c2.setAnio_curricular("Segundo");
    c2.setDivision("A");
	c2.setInstitucion("IFST 16");

    c3= new Curso();
    c3.setAnio("2022");
    c3.setAnio_curricular("Tercero");
    c3.setDivision("A");
	c3.setInstitucion("IFST 16");
	
	Materia.taller2.agregarCorrelatividad(Materia.taller1);
	Materia.paradigmas.agregarCorrelatividad(Materia.diagramacion);
	Materia.paradigmas.agregarCorrelatividad(Materia.logica);

						//		cod_curso	, materia			, profe
	mc1= new Materia_curso (c2.getCodigo_curso(), Materia.taller2, p2);
	mc2= new Materia_curso (c2.getCodigo_curso(), Materia.ingles, p2);
	mc3= new Materia_curso (c2.getCodigo_curso(), Materia.dbase, p2);
	mc4= new Materia_curso (c1.getCodigo_curso(), Materia.taller1, p1);
	mc5= new Materia_curso (c3.getCodigo_curso(), Materia.taller3, p3);
	mc6= new Materia_curso (c2.getCodigo_curso(), Materia.calculo, p2);
	mc7= new Materia_curso (c1.getCodigo_curso(), Materia.diagramacion, p1);
	mc8= new Materia_curso (c1.getCodigo_curso(), Materia.logica, p1);
	
    boolean no_error=true;
	no_error=mc1.agregar_alumnos(34);
	no_error=mc2.agregar_alumnos(24);
	no_error=mc3.agregar_alumnos(28);
	no_error=mc4.agregar_alumnos(31);
	no_error=mc5.agregar_alumnos(30);
	no_error=mc6.agregar_alumnos(32);
	no_error=mc7.agregar_alumnos(36);
	no_error=mc8.agregar_alumnos(28);

	c2.agregar_materia_curso(mc1);
	c2.agregar_materia_curso(mc2);
	c2.agregar_materia_curso(mc3);
	c1.agregar_materia_curso(mc4);
	c3.agregar_materia_curso(mc5);
	c2.agregar_materia_curso(mc6);
	c1.agregar_materia_curso(mc7);
	c1.agregar_materia_curso(mc8);
	
	

    //pruebas clase Acta
    a1=new Acta();
    a1.setMateria("Matematica");
    a1.setPagina("11");
    a1.setCuatrimestre('1');
    a1.setAnio("2022");
    a1.setNro_acta("10020");
    a1.setProfe(p1);

    //Agrego al acta1 todos los alumnos de una materia en un curso: " +
	a1.Agregar_curso( c1.getMaterias_curso(1).getAlumnos(), c1.getMaterias_curso(1).getCantidad_alumnos());

	//										fecha			dni				nota1		nota final
    a1.agregarAlumno("02-09-2022", "33444555", "9 (nueve)", "10 (diez)");
    a1.agregarAlumno("02-09-2022", "23444555", "8 (ocho)", "8 (ocho)");
	a1.agregarAlumno("02-09-2022", "23944555", "7 (siete)", "8 (ocho)");   
    a1.agregarAlumno("02-09-2022", "53822811", "6 (seis)", "8 (ocho)");



    l1=new Libro("QW222", "segundo estante", "IFTS 16");
    l1.agregarActa(a1);

    a2=new Acta();
	a2.Agregar_curso( c1.getMaterias_curso(0).getAlumnos(), c1.getMaterias_curso(0).getCantidad_alumnos());
    l1.agregarActa(a2);

    a3=new Acta();
	a3.Agregar_curso( c1.getMaterias_curso(2).getAlumnos(), c1.getMaterias_curso(2).getCantidad_alumnos());
    l1.agregarActa(a3);

    a4=new Acta();
	a4.Agregar_curso( c2.getMaterias_curso(0).getAlumnos(), c2.getMaterias_curso(0).getCantidad_alumnos());
    l1.agregarActa(a4);

    a5=new Acta();
	a5.Agregar_curso( c1.getMaterias_curso(1).getAlumnos(), c1.getMaterias_curso(1).getCantidad_alumnos());
    l1.agregarActa(a5);



//    System.out.println("Datos del libro:\n"+l1.getDatos_libro());
//    System.out.println("cantidad de actas del libro: "+l1.getCantidad_actas());


	




    l2=new Libro("##~@@22", "ubicacion a determinar", "IFTS 16");
    l2.agregarActa(a1);
    l2.agregarActa(a1);

    l3=new Libro("##~@@11", "ubicacion a determinar", "IFTS 16");
    l3.agregarActa(a1);
    l3.agregarActa(a1);




    //  Instituto
    i1=new Instituto("IFTS 16", "Lascano 4042");


	i1.agregarCurso(c1);
	i1.agregarCurso(c2);
	i1.agregarCurso(c3);

	l1.setUbicacion("Estante 1, Fila 3");
	i1.agregarLibro(l1);
	l2.setUbicacion("Estante 1, Fila 4");
	i1.agregarLibro(l2);
	l3.setUbicacion("Estante 2, Fila 1");
	i1.agregarLibro(l3);

//	System.out.println("Cursos del instituto: "+i1.getCursos());
//	System.out.println("Datos del instituto: "+i1.getDatos());





		
		
		//cursos en el instituto

/*
		i1.agregarCurso(c1);
		System.out.println("\n\n\n Curso agregado?");
		System.out.println("\n Curso en primera posicion \n"+i1.getCurso(0).getDatos_curso());
		System.out.println("\n Alumnos en la primera materia del primer Curso:\n"+i1.getCurso(0).getMaterias_curso(0).getListado_alumnos());
		System.out.println("\n Alumnos en la segunda materia del primer Curso:\n"+i1.getCurso(0).getMaterias_curso(1).getListado_alumnos());
		System.out.println("\n Busca Curso \n"+i1.getCurso(c1.getCodigo_curso()));
		System.out.println("\n Busca Curso \n"+i1.getCurso(""));
		System.out.println("\n materias en curso (primera posicion) \n"+i1.getCurso(0).getListado_materias());

		System.out.println("\n\n\n obtener nota: \n"+Integer.toString (Acta.Notas_to_int("10 (uno)")));
*/	

	   
   }

  }  //fin clase Main








 class Persona
  {

	static String [] Apellidos ={"Gonzalez", "Ramirez", "Benedeti", "Suarez", "Firpo", "Conte", "Cillo", "Pedernera", "Ramirez", "Zarate"};
	static String [] Nombres ={"Maria", "Celeste", "Ramiro", "Juan", "Karina", "Federico", "Manuel", "Elsa", "Karen", "Gonzalo"};
	static String [] Notas ={"2 (dos)", "3 (tres)", "4 (cuatro)", "5 (cinco)", "6 (seis)", "7 (siete)", "8 (ocho)", "9 (nueve)", "10 (diez)"};
	static String [] Dnis ={"23123654", "33215567", "36543876", "41456000", "39877655", "41222334", "48998889", "36544322", "31234433", "40332221"};


    // Atributos
	String apellido; 
	String nombre;
	String dni;
	String altura;	
    int edad;
  
  
    public Persona (String p_ape, String p_nom, String p_dni, int p_edad) {
        this.apellido = p_ape;
        this.nombre = p_nom;
        this.dni = p_dni;
        this.edad = p_edad;
        }


    public Persona (String p_ape, String p_nom, String p_dni, int p_edad, String p_altura) {
        this.apellido = p_ape;
        this.nombre = p_nom;
        this.dni = p_dni;
        this.edad = p_edad;
        this.altura=p_altura;
        }
        
    public Persona () {	}


    public String getApellido() {
        return apellido;
        }
  
    public String getNombre() {
        return nombre;
        }
  
    public String getDni() {
        return dni;
    	}

    public int getEdad() {
        return edad;
    	}


	public void setDni (String p_dni) {
        this.dni= p_dni;
    	}

	public void setNombre (String p_nombre) {
        this.nombre= p_nombre;
    	}

	public void setApellido (String p_apellido) {
        this.apellido= p_apellido;
    	}

	public void setEdad (int p_edad) {
        this.edad= p_edad;
    	}




} //fin clase Persona



 class Alumno extends Persona
  {
    // Atributos
	Materia[] materias_aprobadas;
	int k_materias;

  
    public Alumno (String p_ape, String p_nom, String p_dni, int p_edad) {
        this.apellido = p_ape;
        this.nombre = p_nom;
        this.dni = p_dni;
        this.edad = p_edad;
        this.materias_aprobadas=new Materia[40];
        this.k_materias=0;
        
        }
        
    public Alumno () {	this.materias_aprobadas=new Materia[40];
						this.k_materias=0;}




    public String presentarse() {
        return("Datos del alumno: apellido: "+ getApellido()+
               ", nombre: "+getNombre()+".\nDNI: " +
               getDni());
    	}
    	
    	
	public static Alumno[] getVector_alumno(int p_dimension) {
		
		if (p_dimension < 1 || p_dimension >100)
			return null;
		
		Random rn = new Random();
		int i=0;
		Alumno[] a1=new Alumno[100];
		while (i<p_dimension) {

			a1[i]=new Alumno(Persona.Apellidos[rn.nextInt(10)], Persona.Nombres[rn.nextInt(10)], Persona.Dnis[rn.nextInt(10)], 27); //ape, nom, dni, edad
			i++;
			}
		return a1;
		}





} //fin clase Alumno




class Profe extends Persona
{
// Atributos
Materia[] materias_asignadas;
int k_materias;

// Constructor
public Profe (String p_ape, String p_nom, String p_dni, int p_edad) {
	this.apellido = p_ape;
	this.nombre = p_nom;
	this.dni = p_dni;
	this.edad = p_edad;
	materias_asignadas=new Materia[10];
	k_materias=0;
	}

public Profe () {
	materias_asignadas=new Materia[10];
	k_materias=0;
	
	}



public void addMateria_asignada(Materia p_materia) {
materias_asignadas[k_materias++]=p_materia;
}


public String getMaterias_asignadas() {
	String temp="";
	int indice=0;
	while (indice<k_materias) {
		temp+=materias_asignadas[indice];
		}
	return temp;
	}


//setters


public String presentarse() {
	return("Profesor: "+ getApellido()+
		", "+getNombre()+".\nDNI: " + getDni());
	}

public String evaluar (String p_ape_alumno, String p_nom_materia, int p_nota) {
return ("El alumno "+p_ape_alumno+" obtuvo el siguiente puntaje: "+p_nom_materia+", "+p_nota);

}


} //fin de clase Profe






 class Curso
  {

	static String codes= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789ª!·$%&/()=?¿|@#~½¬{[]}+-.,º¡'*";

    // Atributos
	String codigo_curso;
	String anio; //2022
	String anio_curricular; //Primero
	String division; // A o B
    String institucion;
    Materia_curso[] materias_curso;
    private int k_materias;

  

    public Curso (String p_anio, String p_anio_curr, String p_division, String p_instit) {   

		this.codigo_curso=Curso.newCodigo_curso(6);
        this.division = p_division;
        this.institucion = p_instit;
        this.anio = p_anio;
        this.anio_curricular = p_anio_curr;
        this.materias_curso=new Materia_curso[100];
        this.k_materias=0;
		}
        
    public Curso () {this.codigo_curso = Curso.newCodigo_curso(6);
		
    				 this.materias_curso=new Materia_curso[100];
    				 this.k_materias=0;}


    public String getCodigo_curso() {
        return codigo_curso;
        }
  
    public String getDivision() {
        return division;
        }
  
    public String getInstitucion() {
        return institucion;
        }
  
    public String getAnio() {
        return anio;
        }

    public String getAnio_curricular() {
        return anio_curricular;
        }

    public int getCantidad_materias_curso() {
        return k_materias;
        }


	public void setDivision (String p_division) {
        this.division= p_division;
    	}


	public void setCodigo_curso (String p_cod_curso) {
        this.codigo_curso= p_cod_curso;
    	}

	public void setAnio (String p_anio) {
        this.anio= p_anio;
    	}

	public void setAnio_curricular (String p_anio_curr) {
        this.anio_curricular= p_anio_curr;
    	}

    public void setInstitucion(String p_instit) {
        this.institucion = p_instit;
        }
  
    public String getDatos_curso() {
        return("Datos del curso: \ninstitucion: "+getInstitucion()+", codigo: "+ getCodigo_curso()+
               ", año: "+getAnio()+", division: "+getDivision()+".\ncantidad de materias: "+getCantidad_materias_curso());
    	}

    public boolean agregar_materia_curso(Materia_curso p_mat) {
        this.materias_curso[k_materias++] = p_mat;
        return true;
        }

    public String getListado_materias() {
		int i=0;
        String result="";
        while (i<k_materias){
        	result=result+materias_curso[i].getNombre_materia()+"\n";
            i++;
        	}
		return result;
        }

    public static String newCodigo_curso(int k_caracts) {
		String result="";
		int i=0;
		Random rn = new Random();  
		while (i<k_caracts) {
			result+=codes.charAt(rn.nextInt(91));
			i++;
			}
		
        return result;
        }
        


        
    public Materia_curso getMaterias_curso(int p_indice) {
		return this.materias_curso[p_indice];
        }


    public Alumno[] getAlumnos_materia(int p_indice) {
		return this.materias_curso[p_indice].getAlumnos();
        }


} //fin clase Curso







 class Materia
  {

static Materia taller1= new Materia("Taller1", "front end", "Primer año");
static Materia taller2= new Materia("Taller2", "back end", "Segundo año");
static Materia taller3= new Materia("Taller3", "trabajo profesional", "Tercer año");
static Materia paradigmas= new Materia("Paradigmas de Programacion", "4 paradigmas", "Primer año");
static Materia logica= new Materia("Logica Computacional", "Logica predicados y proposicional", "Primer año");
static Materia diagramacion= new Materia("Diagramacion Logica", "Introduccion a la programacion", "Primer año");
static Materia dbase= new Materia("Bases de Datos", "Diseño e implementacion", "Segundo año");
static Materia calculo= new Materia("Calculo Numerico", "Matematica vectorial", "Segundo año");
static Materia ingles= new Materia("Ingles", "Ingles tecnico", "Segundo año");



    // Atributos
	String nombre_materia; 
	String descripcion_materia; 
	String anio;
	Materia[] correlatividades;
	int k_materias;
	
	


    public Materia (String p_nombre, String p_descripcion, String p_anio) {
        this.nombre_materia = p_nombre;
        this.anio = p_anio;
        this.descripcion_materia = p_descripcion;
        this.correlatividades=new Materia[5];
        this.k_materias=0;
		}

    public Materia (String p_nombre, String p_descripcion, String p_anio, String p_corr1, String p_corr2, String p_corr3) {
        this.nombre_materia = p_nombre;
        this.anio = p_anio;
        this.descripcion_materia = p_descripcion;
        this.correlatividades=new Materia[5];
        this.k_materias=0;
		}

    public Materia () { 
		this.correlatividades=new Materia[5];
		this.k_materias=0;
		}


    public String getNombre_materia() {
        return nombre_materia;
        }

    public String getAnio() {
        return anio;
        }

    public String getDescripcion_materia() {
        return descripcion_materia;
        }

    public String getDatos_materia() {
        return "Nombre: "+this.getNombre_materia()+", descripcion: "+this.getDescripcion_materia()+
				", c: "+this.getAnio();
        }

    public String getCorrelatividades() {
		String result="";
		int i=0;
		while (i<k_materias) {
			result+=correlatividades[i].getNombre_materia()+" ";
			i++;
			}
        return result;
        }


    public void setNombre_materia(String p_nom) {
        nombre_materia=p_nom;
        }

    public void setAnio(String p_anio) {
        anio=p_anio;
        }

    public void setDescripcion_materia(String p_desc) {
        descripcion_materia=p_desc;
        }

    public void agregarCorrelatividad (Materia p_materia) {
        correlatividades[k_materias++]=p_materia;
        }



} //fin clase Materia




 class Materia_curso
  {

    // Atributos
	String codigo_curso;
	Materia datos_materia;
	String anio_dictado; 
	String cuatrimestre_dictado; //0-anual, 1-primero, 2-segundo
    Profe profesor;
	Alumno[] alumnos_materia;
	int k_alumnos;


    public Materia_curso (String p_codigo, Materia p_materia, Profe p_prof) {
		this.codigo_curso=p_codigo;
        this.datos_materia = p_materia;
        this.profesor=p_prof;
        this.alumnos_materia=new Alumno[100];
        this.k_alumnos=0;
        
		}

    public Materia_curso () {
		this.alumnos_materia=new Alumno[100];
		this.k_alumnos=0;
		}


    public String getNombre_materia() {
        return this.datos_materia.getNombre_materia();
        }
        
    public String getProfesor() {
        return this.profesor.presentarse();
        }

    public String getCodigo_curso() {
        return this.codigo_curso;
        }

    public int getCantidad_alumnos() {
        return this.k_alumnos;
        }

    public String getDatos_curso_materia() {
        return getNombre_materia()+", profesor: "+getProfesor();
        }



    public void setProfesor(Profe p_prof) {
        this.profesor=p_prof;
        }

    public boolean agregar_alumno(Alumno p_alumno) {
        this.alumnos_materia[k_alumnos++] = p_alumno;
        return true;
        }

    public boolean agregar_alumnos(int p_cant_alumnos) {
        this.alumnos_materia = Alumno.getVector_alumno(p_cant_alumnos); 
        this.k_alumnos=p_cant_alumnos;
        return true;
        }


    public String getListado_alumnos() {
		int i=0;
        String result="";
        while (i<k_alumnos){
        	result=result+alumnos_materia[i].getApellido()+"\n";
            i++;
        	}
		return result;
        }

    public Alumno[] getAlumnos() {
		return this.alumnos_materia;
        }
        

} //fin clase Materia_curso




class Acta
  {
    // Atributos
	String nro_acta; 
	String anio;
	String materia;
	char cuatrimestre;
	Profe profe;
	String pagina;
	String[][] listado_alumnos;
    int k_alumnos;

	String[] notas={"2 (dos)", "3 (tres)", "4 (cuatro)", "5 (cinco)", "6 (seis)", "7 (siete)", "8 (ocho)", "9 (nueve)", "10 (diez)"};

  

    public Acta () {
        listado_alumnos=new String[100][5]; // 100 alumnos como maximo y por c-u dni_alumno, nota_parcial, nota_final, fecha.
        this.listado_alumnos[0][0]= "test1";
        k_alumnos=0;
        }



    private String getMateria() {
        return materia;
        }

    private String getPagina() {
        return pagina;
        }
  
    private char getCuatrimestre() {
        return cuatrimestre;
        }
  
    public String getNro_acta() {
        return nro_acta;
        }
  
    public String getDatos() {
        return "Número de acta: "+nro_acta+", pagina: "+pagina+"\nMateria: "+materia+", año: "+anio+" - cuatrimestre: "+cuatrimestre;
        }

    public String getListado_alumnos() {
		String result="";
        int i=0;
        while (i<k_alumnos){
            result+=Integer.toString(i+1)+"). DNI: "+listado_alumnos[i][0]+", Nota parcial: "+listado_alumnos[i][1]+", Nota final: "+listado_alumnos[i][2]+", Fecha: "+listado_alumnos[i++][3]+"\n";
            }
		return result;
    	}

    public String getProfesor() {
        return this.profe.presentarse();
    	}


//setters
	public void setProfe (Profe p_prof) {
        profe=p_prof;
    	}

	public void setNro_acta (String p_nro) {
        this.nro_acta= p_nro;
    	}

	public void setMateria (String p_materia) {
        this.materia= p_materia;
    	}

	public void setPagina (String p_pag) {
        this.pagina= p_pag;
    	}

	public void setAnio (String p_anio) {
        this.anio= p_anio;
    	}

	public void setCuatrimestre (char p_cuat) {
        this.cuatrimestre= p_cuat;
    	}



    public String agregarAlumno(String p_fecha, String p_dni, String p_nota_parcial, String p_nota_final) {
        String result="Lista de alumnos en el acta: "+this.nro_acta; 
        
        this.listado_alumnos[k_alumnos][0]=p_dni;
        this.listado_alumnos[k_alumnos][1]=p_nota_parcial;
        this.listado_alumnos[k_alumnos][2]=p_nota_final;
        this.listado_alumnos[k_alumnos++][3]=p_fecha;

        return "alumno agregado al listado";
    	}



    public String buscarAlumno(String p_dni) {
        String result="no se encontró al alumno"; 
        int i=0;
        boolean encontrado=false;
        while (i<k_alumnos && encontrado==false) {
        	if (p_dni.equals(listado_alumnos[i][0])) {
        		result="nota parcial: "+listado_alumnos[i][1]+", nota final: "+listado_alumnos[i][2]+", fecha: "+listado_alumnos[i][3];
                encontrado=true;
                }
            i++;
        	}
		return result;
    	}



    public String editarAlumno(String p_dni, String p_nota1, String p_nota_final, String p_fecha) {
        String result="no se encontró al alumno";
        int i=0;
        boolean encontrado=false;
        while (i<k_alumnos && encontrado==false) {
        	if (p_dni.equals(listado_alumnos[i][0])) {
				listado_alumnos[i][1]=p_nota1;
				listado_alumnos[i][2]=p_nota_final;
				listado_alumnos[i][3]=p_fecha;
        		result="OK edicion:\nnota parcial: "+listado_alumnos[i][1]+", nota final: "+listado_alumnos[i][2]+", fecha: "+listado_alumnos[i][3];
                encontrado=true;
                }
            i++;
        	}
		return result;
    	}


    public String eliminarAlumno(String p_dni) {
        String result="no se encontró al alumno"; 
        int i=0;
        boolean encontrado=false;
        while (i<k_alumnos && encontrado==false) {
        	if (p_dni.equals(listado_alumnos[i][0])) {
				while (i<k_alumnos-1) {
					listado_alumnos[i][0]=listado_alumnos[i+1][0];
					listado_alumnos[i][1]=listado_alumnos[i+1][1];
					listado_alumnos[i][2]=listado_alumnos[i+1][2];
					listado_alumnos[i][3]=listado_alumnos[i+1][3];
					i++;
					}
        		result="OK eliminacion:\n";
                encontrado=true;
                this.k_alumnos--;
                }
            i++;
        	}
		return result;
    	}


    public String Agregar_curso(Alumno[] p_alumnos, int p_k_alumnos) {
        int i=0;
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String result="Alumnos agregados: "; 
        Random rn = new Random();

        while (i<p_k_alumnos) {
			this.agregarAlumno(fecha, p_alumnos[i].getDni(), notas[rn.nextInt(8)], notas[rn.nextInt(8)]); //notas random
            i++;
        	}
		return result+Integer.toString(i);
    	}


    public static int Notas_to_int (String p_nota) {
        int result=0;
		if (p_nota.length()>0 && p_nota.substring(0,1).chars().allMatch(Character::isDigit))
			if (p_nota.substring(1,2).equals("0"))
				result=10;
			else
				result=Integer.parseInt(p_nota.substring(0,1));
		return result;
    	}


    public String getPromedio() {
        int i=0, sum=0, sin_nota, tot=0, nota;
        sin_nota=0;
        String result="";
        while (i<k_alumnos) {
			nota=Notas_to_int(listado_alumnos[i][2]);
			if (nota>0)
				sum=sum+nota;
			else
				sin_nota++;
            i++;
        	}
        if (i-sin_nota>0)
			return Integer.toString(sum/(i-sin_nota));
		else
			return "0";
    	}




} //fin de clase Acta





class Libro
{
// Atributos
String codigo_libro;
String ubicacion; 
String nombre_instituto;
Acta[] actas_del_instituto;
int k_actas;

public void eliminaActa() {
	actas_del_instituto=new Acta[100];
	k_actas=0;
}
// Constructor
public Libro (String p_cod, String p_ubic, String p_instit) {
	this.codigo_libro = p_cod;
	this.ubicacion = p_ubic;
	this.nombre_instituto = p_instit;
	this.actas_del_instituto = new Acta[100];
	k_actas=0;
	}

public Libro () {	
	this.actas_del_instituto = new Acta[100];
	k_actas=0;
	}


public String getCodigo_libro() {
	return codigo_libro;
	}

public String getNombre_instituto() {
	return nombre_instituto;
	}

public String getUbicacion() {
	return ubicacion;
	}

public Acta getActa(int p_pos) {
	return this.actas_del_instituto[p_pos];
	}

public int getCantidad_actas() {
	return k_actas;
	}


public void agregarActa(Acta p_acta) {
actas_del_instituto[k_actas++]=p_acta;
}




//setters
public void setNombre_instituto (String p_nom) {
	this.nombre_instituto= p_nom;
	}

public void setCodigo_libro (String p_cod) {
	this.codigo_libro= p_cod;
	}

public void setUbicacion (String p_ubic) {
	this.ubicacion= p_ubic;
	}


public String getDatos_libro() {
	return("Libro: "+ getCodigo_libro()+", "+getUbicacion()+".\nInstitucion: " +getNombre_instituto());
	}



} //fin de clase Libro




class Instituto
{
// Atributos
String nombre_instituto;
String direccion;
Libro[] deposito_de_libros;
int k_libros;
int k_cursos;
Materia [] materias_programa;
Profe [] profesores_instituto;
Alumno [] alumnos_instituto;


Curso [] cursos_registro;

// Constructor
public Instituto (String p_nom, String p_dire) {
	this.nombre_instituto = p_nom;
	this.direccion = p_dire;
	this.deposito_de_libros = new Libro[100];
	k_libros=0;
	this.cursos_registro = new Curso[10000];
	k_cursos=0;
	}

public Instituto () {
	this.deposito_de_libros = new Libro[100];
	k_libros=0;
	}


public String getNombre_instituto() {
	return nombre_instituto;
	}

public String getDireccion() {
	return direccion;
	}

public Libro getLibro(int p_pos) {
	return this.deposito_de_libros[p_pos];
	}

public Curso getCurso(int p_pos) {
	return this.cursos_registro[p_pos];
	}

public String getCursos() {
	int i=0;
	String result="";
	while (i<k_cursos) {
		result+=this.cursos_registro[i].getDatos_curso()+"\n";
		i++;
		}
	return result;
	}


public String getCurso(String p_code) { 
	int indice=0;
	while (indice<k_cursos && !this.cursos_registro[indice].getCodigo_curso().equals(p_code)) {
		indice++;
		}

	if (indice<k_cursos)
		return "encontrado";
	else
		return "NO encontrado";
	}

public int getCantidad_libros() {
	return k_libros;
	}

public int getCantidad_cursos() {
	return k_cursos;
	}


public void agregarLibro(Libro p_libro) {
	deposito_de_libros[k_libros++]=p_libro;
	}

public void agregarCurso(Curso p_curso) {
	cursos_registro[k_cursos++]=p_curso;
	}




//setters
public void setNombre_instituto (String p_nom) {
	this.nombre_instituto= p_nom;
	}

public void setDireccion (String p_dire) {
	this.direccion= p_dire;
	}



public String getDatos() {
	return("Instituto: "+ getNombre_instituto()+", Direccion: "+getDireccion()+".\nCantidad de libros: " +Integer.toString(getCantidad_libros())+".\nCantidad de cursos: " +Integer.toString(getCantidad_cursos()));
	}



} //fin de clase Instituto