package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.dto.OrderProductDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.OrderProduct;
import com.metacube.shoppingcart.modal.Order_Payement;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.modal.User;

public abstract class GenericHibernateDao<T, ID extends Serializable> implements AbstractDao<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Class<T> modelClass;

	public Class<T> getModelClass() {
		return modelClass;
	}

	public GenericHibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/**
	 * 
	 * To save the product to the database
	 * 
	 */
	@Override
	public <S extends T> Status save(final S entity) {
		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();

			/* saving the product */
			session.save(entity);
			System.out.println("Inserted Successfully");

		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/**
	 * To find the particular product with the given id
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findOne(ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass()).add(Restrictions.eq("id", primaryKey));
		Product product = (Product) cr.uniqueResult();
		return (T) product;
	}

	/**
	 * To find the particular user with the given id
	 * 
	 */
	@Override
	public UserDto findOne(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass()).add(Restrictions.eq("email", email));
		User user = (User) cr.uniqueResult();
		if(user == null) {
			return null;
		}
		return getUserMiniCartDetails(user);
	}

	/**
	 * To find the minicart of the user with the given id
	 * 
	 */
	@SuppressWarnings("unchecked")
	private UserDto getUserMiniCartDetails(User user) {

		Double totalPrice = 0.00;
		UserDto userCartDetail = new UserDto();
		userCartDetail.setUser(user);
		Session session = this.sessionFactory.getCurrentSession();

		Criteria cr = session.createCriteria(Cart.class).add(Restrictions.eq("userId", user.getId()));

		List<Cart> cartList = cr.list();
		userCartDetail.setTotalNoproduct(cartList.size());
		for (int i = 0; i < cartList.size(); i++) {

			int id = cartList.get(i).getProductId();

			cr = session.createCriteria(Product.class).add(Restrictions.eq("id", id));
			Product curproduct = (Product) cr.uniqueResult();
			totalPrice += curproduct.getPrice();

		}
		userCartDetail.setTotalCost(totalPrice);

		return userCartDetail;
	}

	
	/**
	 * To add the product to the cart
	 * 
	 */
	@Override
	public Status addToCart(Cart cart) {
		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
	
			Cart curcart = (Cart) session.createCriteria(getModelClass())
					.add(Restrictions.eq("userId", cart.getUserId()))
					.add(Restrictions.eq("productId", cart.getProductId())).uniqueResult();

			
			
			
			if(curcart == null ) {
				session.save(cart);
			}else {
				result = Status.FALIURE;
			}
			
			System.out.println("Inserted Successfully");

		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Product> getCartProducts(int userId) {

		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass()).add(Restrictions.eq("userId", userId));
		List<Cart> cartList = cr.list();
		List<Product> cartProduct = new ArrayList<>();
		for (int i = 0; i < cartList.size(); i++) {

			int id = cartList.get(i).getProductId();
			cr = session.createCriteria(Product.class).add(Restrictions.eq("id", id));
			Product curproduct = (Product) cr.uniqueResult();
			cartProduct.add(curproduct);

		}

		return cartProduct;

	}

	@Override
	public Status deleteProductFromCart(Cart cart) {
		Status result = Status.Success;
		try {

			Session session = this.sessionFactory.getCurrentSession();
			Cart curcart = (Cart) session.createCriteria(getModelClass())
					.add(Restrictions.eq("userId", cart.getUserId()))
					.add(Restrictions.eq("productId", cart.getProductId())).uniqueResult();

			session.delete(curcart);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = Status.Error_Occured;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<T> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		List<T> personsList = cr.list();
		return personsList;
	}

	

	@Override
	public Status delete(final ID primaryKey) {
		Status result = Status.Success;
		try {

			Session session = this.sessionFactory.getCurrentSession();
			Product product = (Product) session.get(Product.class, primaryKey);
			session.delete(product);

		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	@Override
	public <S extends T> Status edit(S entity, ID primaryKey) {
		
		Status result = Status.Added;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Product update = (Product) entity;
			Product product = (Product) session.get(Product.class, primaryKey);
			product.setName(update.getName());
			product.setPrice(update.getPrice());
			session.update(product);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	@Override
	public int placeOrder(Order_Payement curorder) {

		int curorderId = 0;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			curorderId = (int) session.save(curorder);
			System.out.println("Inserted Successfully");

		} catch (Exception e) {

		}
		return curorderId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Status saveOrderProduct(Order_Payement curorder, ArrayList<Product> cartProducts) {

		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();

			for (Product prod : cartProducts) {
				OrderProduct ordprod = new OrderProduct();
				ordprod.setOrderId(curorder.getOrderId());
				ordprod.setProductId(prod.getId());
				session.save(ordprod);

			}

			session = this.sessionFactory.getCurrentSession();

			int userId = curorder.getUserId();

			Criteria cr = session.createCriteria(Cart.class).add(Restrictions.eq("userId", userId));

			List<Cart> cartTodelete = cr.list();

			for (Cart cart : cartTodelete) {
				session.delete(cart);
			}

			System.out.println("Inserted Successfully");

		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Order_Payement> getMyOrders(int userId) {

		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass()).add(Restrictions.eq("userId", userId));
		List<T> myorders = cr.list();

		return (Iterable<Order_Payement>) myorders;

	}

	@Override
	public OrderProductDto getorderproducts(int orderId) {

		OrderProductDto thisorderobject = new OrderProductDto();

		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass()).add(Restrictions.eq("orderId", orderId));

		@SuppressWarnings("unchecked")
		ArrayList<OrderProduct> productIdsofthisorder = (ArrayList<OrderProduct>) cr.list();

		Order_Payement curorder = (Order_Payement) session.createCriteria(Order_Payement.class)
				.add(Restrictions.eq("orderId", orderId)).uniqueResult();
		thisorderobject.setTotal(curorder.getTotal());

		List<Product> listOfProduct = new ArrayList<Product>();

		for (OrderProduct orderprod : productIdsofthisorder) {

			session = this.sessionFactory.getCurrentSession();
			cr = session.createCriteria(Product.class).add(Restrictions.eq("id", orderprod.getProductId()));
			Product product = (Product) cr.uniqueResult();
			listOfProduct.add(product);
		}

		thisorderobject.setProducts(listOfProduct.toArray(new Product[listOfProduct.size()]));

		return thisorderobject;
	}

}
