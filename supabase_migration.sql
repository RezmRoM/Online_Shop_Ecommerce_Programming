-- 1. Create Tables
CREATE TABLE categories (
    id int8 PRIMARY KEY,
    title text NOT NULL,
    pic_url text NOT NULL
);

CREATE TABLE items (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    category_id int8 REFERENCES categories(id),
    title text NOT NULL,
    description text,
    price float8 DEFAULT 0.0,
    rating float8 DEFAULT 0.0,
    show_recommended boolean DEFAULT false,
    pic_urls text[] DEFAULT '{}',
    models text[] DEFAULT '{}'
);

CREATE TABLE banners (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    url text NOT NULL
);

-- 2. Create Storage Bucket (Public)
-- Note: It is recommended to create this via the Supabase Dashboard: Storage -> New Bucket -> "ecommerce" (Public)
-- If you have permissions, you can use the following (requires admin/extensions):
-- INSERT INTO storage.buckets (id, name, public) VALUES ('ecommerce', 'ecommerce', true);

-- 3. Insert Banners
-- REPLACE YOUR_PROJECT_REF with your actual project reference (e.g. xyzabc123)
INSERT INTO banners (url) VALUES
('https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/banner1.png'),
('https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/banner2.png');

-- 4. Insert Categories
INSERT INTO categories (id, title, pic_url) VALUES
(0, 'Pc', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat1.png'),
(1, 'Smartphone', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat2.png'),
(2, 'Headphone', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat3.png'),
(3, 'Console', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat4.png'),
(4, 'Camera', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat5.png'),
(5, 'Smartwatch', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat6.png');

-- 5. Insert Items
INSERT INTO items (category_id, title, description, price, rating, show_recommended, pic_urls, models) VALUES
(2, 'Headphone 12A', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 95, 4.6, true, ARRAY['https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat1_1.png'], ARRAY['Black', 'Purple', 'Pink', 'Blue']),
(0, 'Business Laptop', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 550, 4.7, true, ARRAY['https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat2_1.png', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat2_2.png', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat2_3.png', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat2_4.png', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat2_5.png'], ARRAY['core i3', 'core i5', 'core i7']),
(0, 'Laptop A34f', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 550, 4.7, false, ARRAY['https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/loptop3.png'], ARRAY['core i3', 'core i5', 'core i7']),
(0, 'Laptop 128Gig', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 550, 4.7, false, ARRAY['https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/loptop2.png'], ARRAY['core i3', 'core i5', 'core i7']),
(0, 'laptop B2003', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 550, 4.7, false, ARRAY['https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/loptop4.png'], ARRAY['core i3', 'core i5', 'core i7']),
(0, 'Business Laptop', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 550, 4.7, true, ARRAY['https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/loptop5.png'], ARRAY['core i3', 'core i5', 'core i7']),
(0, 'Laptop MOH345', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 550, 4.7, false, ARRAY['https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/loptop6.png'], ARRAY['core i3', 'core i5', 'core i7']),
(4, 'Digital Camera', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 750, 4.5, false, ARRAY['https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat3_1.png', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat3_2.png', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat3_3.png', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat3_4.png'], ARRAY['18-55mm', '35-200mm', '75-300mm']),
(3, 'PS5', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 500, 4.9, false, ARRAY['https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat4_1.png', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat4_2.png', 'https://YOUR_PROJECT_REF.supabase.co/storage/v1/object/public/ecommerce/cat4_3.png'], ARRAY['Slim', 'Slim Digital']);

-- 6. Enable RLS and set public policies
ALTER TABLE categories ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Allow public read" ON categories FOR SELECT USING (true);

ALTER TABLE items ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Allow public read" ON items FOR SELECT USING (true);

ALTER TABLE banners ENABLE ROW LEVEL SECURITY;
CREATE POLICY "Allow public read" ON banners FOR SELECT USING (true);
