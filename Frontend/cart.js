const cartContainer = document.getElementById('cartContainer');
const checkoutBtn = document.getElementById('checkoutBtn');

function renderCart(){
  const cart = JSON.parse(localStorage.getItem('cart') || '[]');
  if(cart.length === 0){
    cartContainer.innerHTML = '<p class="text-gray-500">Your cart is empty.</p>';
    checkoutBtn.style.display = 'none';
    return;
  }
  checkoutBtn.style.display = 'inline-block';

  cartContainer.innerHTML = cart.map(item => `
    <div class="flex items-center gap-4 border-b py-3">
      <img src="${item.img}" class="w-20 h-20 object-cover rounded" />
      <div class="flex-1">
        <div class="font-semibold">${item.name}</div>
        <div class="text-gray-500">₹${item.price} x ${item.qty}</div>
      </div>
      <div class="flex items-center gap-2">
        <button class="px-3 py-1 border rounded" onclick="changeQty(${item.id}, -1)">-</button>
        <div>${item.qty}</div>
        <button class="px-3 py-1 border rounded" onclick="changeQty(${item.id}, 1)">+</button>
      </div>
    </div>
  `).join('');
}

function changeQty(id, delta){
  const cart = JSON.parse(localStorage.getItem('cart') || '[]');
  const item = cart.find(i => i.id === id);
  if(!item) return;
  item.qty += delta;
  if(item.qty <= 0){
    const idx = cart.findIndex(i => i.id === id);
    cart.splice(idx,1);
  }
  localStorage.setItem('cart', JSON.stringify(cart));
  renderCart();
}

checkoutBtn?.addEventListener('click', () => {
  const cart = JSON.parse(localStorage.getItem('cart') || '[]');
  if(cart.length === 0) return alert('Cart empty');
  const orders = JSON.parse(localStorage.getItem('orders') || '[]');
  cart.forEach(item => orders.unshift({ id: Date.now()+Math.random(), name: item.name, price: item.price, qty: item.qty, date: new Date().toLocaleString() }));
  localStorage.setItem('orders', JSON.stringify(orders));
  localStorage.removeItem('cart');
  alert('Order placed (demo)');
  renderCart();
});

renderCart();
