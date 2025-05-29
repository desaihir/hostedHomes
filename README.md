# HostedHomes 🏡

HostedHomes is a full-stack web application inspired by Airbnb, built using **Java Spring Boot**, **Hibernate ORM**, **JSP**, and **PostgreSQL**. It allows users to browse, search, and book vacation rentals, while hosts can list their properties and manage reservations.

---

## 🌟 Features

✅ User Registration and Login  
✅ Search Listings by Location  
✅ View Listings with Details and Images  
✅ Make Reservations (with Date and Price Calculation)  
✅ Host Mode: Add and Manage Listings  
✅ Email Notifications for Bookings  
✅ Responsive Frontend using JSP + CSS  

---

## 🚀 Tech Stack

| **Backend**      | **Frontend**              | **Database**    | **Others**                  |
|------------------|---------------------------|------------------|----------------------------|
| Java 17          | JSP + JSTL                | PostgreSQL       | Apache Tomcat (Embedded)   |
| Spring Boot      | HTML, CSS, JavaScript     | Hibernate ORM    | Maven                      |
| Spring Security  |                          |                  |                            |
| Hibernate ORM    |                          |                  |                            |
| Java Mail API    |                          |                  |                            |

---

## 📦 Database Schema (Core Tables)

### Users Table
- `user_id` (PK)
- `name`, `email`, `password_hash`
- `phone_number`, `created_at`

### Listings Table
- `listing_id` (PK)
- `host_id` (FK), `title`, `description`, `location`, `price_per_night`

### Reservations Table
- `reservation_id` (PK)
- `listing_id` (FK), `guest_id` (FK), `start_date`, `end_date`, `total_price`

---

## 🛠️ Setup & Run Locally

1️⃣ **Clone the Repository**
```bash
git clone https://github.com/your-username/hostedHomes.git
cd hostedHomes
