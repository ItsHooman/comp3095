/*print('START');

db = db.getSiblingDB('product-service'); // Switch to the desired database

db.createUser({
    user: 'admin',
    pwd: 'password',
    roles: [{ role: 'readWrite', db: 'product-service' }] // Assign roles
});

db.createCollection('user'); // Create a collection named 'user'

print('END'); */

db = db.getSiblingDB('admin'); // Switch to the admin database

db.createUser({
    user: 'admin',
    pwd: 'password',
    roles: [{ role: 'root', db: 'admin' }] // Assign root role
});

db = db.getSiblingDB('product-service'); // Switch to the desired database

db.createUser({
    user: 'admin',
    pwd: 'password',
    roles: [{ role: 'readWrite', db: 'product-service' }] // Assign roles
});

db.createCollection('user'); // Create a collection named 'user'

print('END');

