Feature: PruebaQA

  @BuscarProducto @TestAutomation
  Scenario: Buscar producto y ver descripcion
    Given Carga sitio web de "ABSTRACTA"
    When Se busca el producto "iPhone"
    And Se selecciona el primer producto de la busqueda
    Then Se valida que se vea la descripcion del producto

  @AgregarProducto @TestAutomation
  Scenario: Agregar producto al Carrito
    Given Carga sitio web de "ABSTRACTA"
    When Se busca el producto "iPhone"
    And Se selecciona el primer producto de la busqueda
    And Se agrega producto al carrito de compras
    And Se navega a view cart
    Then Se valida que el producto seleccionado se encuentra en el carrito

  @EliminarProducto @TestAutomation
  Scenario: Eliminar producto del carrito
    Given Carga sitio web de "ABSTRACTA"
    When Se busca el producto "iPhone"
    And Se selecciona el primer producto de la busqueda
    And Se agrega producto al carrito de compras
    And Se navega a view cart
    And Se elimina el producto del carrito
    Then Se valida el mensaje "Your shopping cart is empty!"

