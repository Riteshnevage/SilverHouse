package com.vithai_silverhouse.service;





@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) { this.productRepository = productRepository; }

    public List<Products> getAllProducts() { return productRepository.findAll(); }
    public Product addProduct(Product product) { return productRepository.save(product); }
    public void deleteProduct(Long id) { productRepository.deleteById(id); }
}

