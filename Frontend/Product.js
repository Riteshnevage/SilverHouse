const API = "http://localhost:8080/api/products";
const productsGrid = document.getElementById('productsGrid');
const searchInput = document.getElementById('search');

async function fetchProducts(){
  try{
    const res = await fetch(API);
    const data = await res.json();
    window.__products = data;
    renderProducts(data);
  }catch(e){
    productsGrid.innerHTML = `<div class="col-span-3 p-6 text-red-600">Could not load products. Make sure backend is running.</div>`;
  }
}

function renderProducts(list){
  if(!list || list.length===0){
    productsGrid.innerHTML = `<div class="col-span-3 p-6 text-gray-600">No products found.</div>`;
    return;
  }
  productsGrid.innerHTML = list.map(p => `
    <div class="bg-white rounded-2xl shadow p-4 flex flex-col">
      <img src="${p.img}" alt="${p.name}" class="w-full h-48 object-cover rounded-md">
      <h3 class="mt-3 text-lg font-semibold">${p.name}</h3>
      <p class="text-gray-500 mt-1">${p.category}</p>
      <div class="mt-2 flex justify-between items-center">
        <div class="text-xl font-bold">₹${p.price.toLocaleString()}</div>
        <div class="flex gap-2">
          <button onclick="addToCart(${p.id})" class="bg-purple-600 text-white px-3 py-2 rounded">Add</button>
          <button onclick="buyNow(${p.id})" class="bg-gray-200 px-3 py-2 rounded">Buy</button>
        </div>
      </div>
    </div>
  `).join('');
}

function addToCart(id){
  const p = window.__products.find(x => x.id === id);
  if(!p) return alert('Product not found');
  const cart = JSON.parse(localStorage.getItem('cart') || '[]');
  const ex = cart.find(c => c.id === id);
  if(ex) ex.qty++;
  else cart.push({ id, name: p.name, price: p.price, img: p.img, qty: 1});
  localStorage.setItem('cart', JSON.stringify(cart));
  alert(`${p.name} added to cart`);
}

function buyNow(id){
  const p = window.__products.find(x => x.id === id);
  const orders = JSON.parse(localStorage.getItem('orders') || '[]');
  orders.unshift({ id: Date.now(), name: p.name, price: p.price, qty: 1, date: new Date().toLocaleString() });
  localStorage.setItem('orders', JSON.stringify(orders));
  window.location.href = 'cart.html';
}

searchInput?.addEventListener('input', (e) => {
  const q = (e.target.value || '').toLowerCase();
  const filtered = (window.__products || []).filter(p => p.name.toLowerCase().includes(q) || p.category.toLowerCase().includes(q));
  renderProducts(filtered);
});

fetchProducts();
