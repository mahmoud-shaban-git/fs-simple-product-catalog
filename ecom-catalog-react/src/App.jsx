import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => setProducts(data));

    fetch('http://localhost:8080/api/categories')
      .then(response => response.json())
      .then(data => setCategories(data));
  }, []);

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  };

  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  };

  const filteredProducts = products
              .filter(product => {
                return (
                  (selectedCategory ? product.category.id === selectedCategory : true) 
                  && 
                  product.name.toLowerCase().includes(searchTerm.toLowerCase())
                )
              })
              .sort((a, b) => {
                if (sortOrder === "asc"){
                  return a.price - b.price;
                } else {
                  return b.price - a.price;
                }
              });

  return (
    <div className='container'>
      <h1 className='my-4'> ملابس و اكسسوارات</h1>

      <div className='row align-items-center mb-4'>
        <div className='col-md-3 col-sm-12 mb-2'>
          <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>
        </div>

        <div className='col-md-5 col-sm-12 mb-2'>
          <input
            type='text'
            className='form-control'
            placeholder='ابحث عن منتج'
            onChange={handleSearchChange}
            />
        </div>

        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
          <option value="asc">رتب حسب السعر: من الأقل إلى الأعلى</option>
          <option value="desc">رتب حسب السعر: من الأعلى إلى الأقل</option>
          </select>
        </div>
      </div>

      <div>
        {filteredProducts.length ? (
          // Display products
          <ProductList products={filteredProducts}/>
        ) : (
          <p>لم يتم العثور على منتجات</p>

        )}
      </div>
    </div>
  )
}

export default App