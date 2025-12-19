<<<<<<< HEAD
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import { useState } from "react";

function Home() {
  return <h2>Welcome to Sneaker Store</h2>;
}

function Sneakers() {
  return <h2>Sneakers Catalog (coming soon)</h2>;
}
=======
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Navbar from './Components/Navbar';
import './App.css';

import Home from './Pages/Home';
import Sneaker from './Pages/Sneaker';
import Product from './Pages/Product';
import Cart from './Pages/Cart';
import LoginSignup from './Pages/LoginSignup';
import Register from './Pages/Register';
import Checkout from './Pages/Checkout';
import OrderSummary from './Pages/OrderSummary';
import OrderSuccess from './Pages/OrderSuccess';

// Customer pages
import Profile from './Pages/Profile';
import Orders from './Pages/Orders';
import ChangePassword from './Pages/ChangePassword';
>>>>>>> dev

function Cart() {
  return <h2>Your Cart (coming soon)</h2>;
}

function App() {
  return (
<<<<<<< HEAD
    <Router>
      <header>
        <h1>Sneaker Store</h1>
        <nav>
          <Link to="/">Home</Link> |{" "}
          <Link to="/sneakers">Sneakers</Link> |{" "}
          <Link to="/cart">Cart</Link>
        </nav>
      </header>
      <main>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/sneakers" element={<Sneakers />} />
          <Route path="/cart" element={<Cart />} />
        </Routes>
      </main>
    </Router>
=======
    <AuthProvider>
      <SneakerContextProvider>
        <CartContextProvider>
          <BrowserRouter>
            <Navbar />
            <Routes>

              {/* ---------- Public Routes ---------- */}
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<LoginSignup />} />
              <Route path="/register" element={<Register />} />
              <Route path="/sneakers" element={<Sneaker />} />
              <Route path="/sneakers/:productId" element={<Product />} />
              <Route path="/cart" element={<Cart />} />
              <Route path="/checkout" element={<Checkout />} />
              <Route path="/order-success" element={<OrderSuccess />} />

              {/* ---------- Private Customer Routes ---------- */}
              <Route
                path="/profile"
                element={
                  <PrivateRoute>
                    <Profile />
                  </PrivateRoute>
                }
              />

              <Route
                path="/orders"
                element={
                  <PrivateRoute>
                    <Orders />
                  </PrivateRoute>
                }
              />

              <Route
                path="/orders/:orderId"
                element={
                  <PrivateRoute>
                    <OrderSummary />
                  </PrivateRoute>
                }
              />

              <Route
                path="/change-password"
                element={
                  <PrivateRoute>
                    <ChangePassword />
                  </PrivateRoute>
                }
              />

              {/* ---------- Admin Routes ---------- */}
              <Route
                path="/admin"
                element={
                  <AdminRoute>
                    <AdminPage />
                  </AdminRoute>
                }
              />

              <Route
                path="/adminCustomers"
                element={
                  <AdminRoute>
                    <AdminCustomers />
                  </AdminRoute>
                }
              />

              <Route
                path="/adminOrders"
                element={
                  <AdminRoute>
                    <AdminOrders />
                  </AdminRoute>
                }
              />
              <Route
                path="/admin/orders"
                element={
                  <AdminRoute>
                    <AdminOrders />
                  </AdminRoute>
                }
              />

              <Route
                path="/admin/orders/:orderId"
                element={
                  <AdminRoute>
                    <OrderSummary />
                  </AdminRoute>
                }
              />

              <Route
                path="/adminProducts"
                element={
                  <AdminRoute>
                    <AdminProducts />
                  </AdminRoute>
                }
              />

            </Routes>
          </BrowserRouter>
        </CartContextProvider>
      </SneakerContextProvider>
    </AuthProvider>
>>>>>>> dev
  );
}

export default App;
