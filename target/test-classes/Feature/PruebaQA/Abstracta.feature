Feature: PruebaQA

  @BuscarProducto @TestAutomation
  Scenario: Buscar producto "Iphone"
    Given Carga sitio web de "ABSTRACTA"
    When Se busca el producto "iPhone"
    And Se selecciona el primer producto de la busqueda
    And Se agrega producto al carrito de compras
    And Se navega a view cart
    Then se valida que el producto seleccionado se encuentra en el carrito
    And se elimina el producto del carrito
    And se valida el mensaje "Your shopping cart is empty!"

