    // When the user clicks on <div>, open the popup
    function pop1() {
        var popup = document.getElementById("pop1");
        popup.classList.toggle("show");
      }
  
      function pop2() {
        var popup = document.getElementById("pop2");
        popup.classList.toggle("show");
      }
  
      function pop3() {
        var popup = document.getElementById("pop3");
        popup.classList.toggle("show");
      }
  
      function pop4() {
        var popup = document.getElementById("pop4");
        popup.classList.toggle("show");
      }
  
      let shop = document.getElementById("shop");
  
      console.log(shop);
  
      let basket = JSON.parse(localStorage.getItem("data")) || [];
  
      let generateShop = () => {
        return (shop.innerHTML= shopItemsData.map((x)=>{
          let {id, name, price, desc, img} = x;
          let search = basket.find((x)=>x.id === id) || []; // || ->  or return nothing
          return `
          <div class="column">
            <div class="card">
              <div id=product-id-${id} class="item">
                <img src= ${img} alt="Avatar" style="width:100%">
                <h4 style="font-family: MV Boli;"><b>${name}</b></h4> 
                <p style="font-family: MV Boli;">${desc}</p>
                <p>$${price}</p>  
                <div class="popup" onclick="pop1()" style="font-family: MV Boli;"><b>Click here for item details</b>
                  <span class="popuptext" id="pop1">A classic pant look built for maximum comfort and style <br><br> Size: 34 <br><br> Price: $60.00 + $4.99 shipping <br><br> **Click popup again to close**</span>
                </div>
                <br><br>
                <div class="addCartButton">
                  <button class="button" onclick="increment(${id})">Add to Cart</button>
                  <br><br>
                  <button class="button" onclick="decrement(${id})">Decrement</button>
                  <div id=${id} class="quantity">
                    ${search.item === undefined ? 0 : search.item}
                  </div>
                </div>
              </div>
            </div>
          </div>
        `;
        })
        .join(""));
      };
   
  
      generateShop();
  
      let increment = (id) => {
        let selectedItem = id;
        let search = basket.find((x) => x.id === selectedItem.id);
  
        if (search === undefined) {
          basket.push({
            id: selectedItem.id,
            item: 1,
          });
        } else {
          search.item += 1;
        }
        localStorage.setItem("data", JSON.stringify(basket));
        // console.log(basket);
        update(selectedItem.id);
      };
  
      let decrement = (id) => {
        let selectedItem = id;
        let search = basket.find((x) => x.id === selectedItem.id);
  
        if (search.item === 0) return;
        else {
          search.item -= 1;
        }
        localStorage.setItem("data", JSON.stringify(basket));
        // console.log(basket);
        update(selectedItem.id);
      };
  
      let update = (id) => {
        let search = basket.find((x) => x.id === id);
        // console.log(search); // This function gives "id: " and "item: "
        // console.log(search.item);
        document.getElementById(id).innerHTML = search.item; // reference to: <div id=${id} class="quantity">0</div>
        calculation();
      };
  
      let calculation = () => {
        let cartIcon = document.getElementById("cartAmount");
        cartIcon.innerHTML = basket.map((x) => x.item).reduce((x, y) => x + y, 0);
      };
  
      // Every time application loads, calculation() will run regardless
      // Prevent un-updated itwm amount on cart-icon will page gets refresh
      calculation();