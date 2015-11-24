package funcoes

object companhia extends App {
  
  // 1) A
  // funcao que retorna assentos livres de uma aeronave
  // passando uma aeronave e uma funcao por parametro
  
  def assentosLivres(aeronave:List[List[Int]])(f:(List[Int]) => Int):Int = {
    var resultado = 0
    aeronave.foreach( x => {
      resultado += f(x)
    })
    
    resultado
  }
  
  //  1) B
  //  funcao para retornar numero de assentos livres
  //  passando uma fila de assentos por parâmetro
  
  var assentosLivresPorFila = (lista:List[Int]) => {
    var resultado = 0
    lista.foreach( x => {
        if(x == 0)
          resultado += 1
    })
    
    resultado
  }
  
  var aeronave = List(
              List(0, 0, 1),
              List(1, 0, 1)
           )
  
  // Assentos livres de uma aeronave
  println(assentosLivres(aeronave)(assentosLivresPorFila))
  // Assentos livres por fila  
  println(assentosLivresPorFila(aeronave(0)))
  
}