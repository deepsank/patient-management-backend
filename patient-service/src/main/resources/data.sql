-- Ensure the 'patient_model' table exists
CREATE TABLE IF NOT EXISTS patient_model
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    address         VARCHAR(255)        NOT NULL,
    date_of_birth   DATE                NOT NULL,
    registered_date DATE                NOT NULL
    );

-- Insert Indian patient data
INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'Rahul Sharma',
       'rahul.sharma@example.in',
       '12 MG Road, Bengaluru, Karnataka',
       '1985-06-15',
       '2024-01-10'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '123e4567-e89b-12d3-a456-426614174000');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174001',
       'Priya Verma',
       'priya.verma@example.in',
       '45 Lajpat Nagar, New Delhi',
       '1990-09-23',
       '2023-12-01'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '123e4567-e89b-12d3-a456-426614174001');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174002',
       'Anjali Mehta',
       'anjali.mehta@example.in',
       '33 Nehru Street, Pune, Maharashtra',
       '1978-03-12',
       '2022-06-20'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '123e4567-e89b-12d3-a456-426614174002');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174003',
       'Amit Singh',
       'amit.singh@example.in',
       '88 Park Street, Kolkata, West Bengal',
       '1982-11-30',
       '2023-05-14'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '123e4567-e89b-12d3-a456-426614174003');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174004',
       'Sneha Iyer',
       'sneha.iyer@example.in',
       '5 Anna Salai, Chennai, Tamil Nadu',
       '1995-02-05',
       '2024-03-01'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '123e4567-e89b-12d3-a456-426614174004');

-- Additional Indian patients
INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174005',
       'Mohit Reddy',
       'mohit.reddy@example.in',
       '110 Banjara Hills, Hyderabad, Telangana',
       '1988-07-25',
       '2024-02-15'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '223e4567-e89b-12d3-a456-426614174005');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174006',
       'Neha Kapoor',
       'neha.kapoor@example.in',
       '23 Sector 17, Chandigarh',
       '1992-04-18',
       '2023-08-25'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '223e4567-e89b-12d3-a456-426614174006');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174007',
       'Ravi Deshmukh',
       'ravi.deshmukh@example.in',
       '9 MG Road, Nagpur, Maharashtra',
       '1975-01-11',
       '2022-10-10'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '223e4567-e89b-12d3-a456-426614174007');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174008',
       'Aarushi Jain',
       'aarushi.jain@example.in',
       '77 Civil Lines, Jaipur, Rajasthan',
       '1989-09-02',
       '2024-04-20'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '223e4567-e89b-12d3-a456-426614174008');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174009',
       'Karan Malhotra',
       'karan.malhotra@example.in',
       '34 Gariahat, Kolkata, West Bengal',
       '1993-11-15',
       '2023-06-30'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '223e4567-e89b-12d3-a456-426614174009');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174010',
       'Divya Nair',
       'divya.nair@example.in',
       '56 Panampilly Nagar, Kochi, Kerala',
       '1980-08-09',
       '2023-01-22'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '223e4567-e89b-12d3-a456-426614174010');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174011',
       'Arjun Bhatia',
       'arjun.bhatia@example.in',
       '14 Vasant Vihar, New Delhi',
       '1984-05-03',
       '2024-05-12'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '223e4567-e89b-12d3-a456-426614174011');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174012',
       'Meera Pillai',
       'meera.pillai@example.in',
       '89 Residency Road, Bengaluru, Karnataka',
       '1991-12-25',
       '2022-11-11'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '223e4567-e89b-12d3-a456-426614174012');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174013',
       'Tarun Joshi',
       'tarun.joshi@example.in',
       '72 Sadar Bazar, Dehradun, Uttarakhand',
       '1976-06-08',
       '2023-09-19'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '223e4567-e89b-12d3-a456-426614174013');

INSERT INTO patient_model (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174014',
       'Ritika Chauhan',
       'ritika.chauhan@example.in',
       '15 VIP Road, Indore, Madhya Pradesh',
       '1987-10-17',
       '2024-03-29'
    WHERE NOT EXISTS (SELECT 1 FROM patient_model WHERE id = '223e4567-e89b-12d3-a456-426614174014');
