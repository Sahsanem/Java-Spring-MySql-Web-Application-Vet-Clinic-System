-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 27 Eyl 2021, 08:22:57
-- Sunucu sürümü: 10.4.20-MariaDB
-- PHP Sürümü: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `bulutvet`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `agenda`
--

CREATE TABLE `agenda` (
  `aid` int(11) NOT NULL,
  `active_checked` bit(1) DEFAULT NULL,
  `agenda_date` datetime DEFAULT NULL,
  `agenda_desc` varchar(255) DEFAULT NULL,
  `agenda_hours` varchar(255) DEFAULT NULL,
  `agenda_title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `agenda`
--

INSERT INTO `agenda` (`aid`, `active_checked`, `agenda_date`, `agenda_desc`, `agenda_hours`, `agenda_title`) VALUES
(2, b'0', '2021-09-25 03:00:00', 'sfsfr', '18:32', 'Sinema');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `animal`
--

CREATE TABLE `animal` (
  `aid` int(11) NOT NULL,
  `cip_no` int(11) DEFAULT NULL,
  `cus_no` int(11) NOT NULL,
  `gender` int(11) NOT NULL,
  `karne_no` int(11) NOT NULL,
  `p_birth` datetime DEFAULT NULL,
  `p_name` varchar(255) DEFAULT NULL,
  `p_race` varchar(255) DEFAULT NULL,
  `p_type` varchar(255) DEFAULT NULL,
  `pcolor` varchar(255) DEFAULT NULL,
  `spayed` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `animal`
--

INSERT INTO `animal` (`aid`, `cip_no`, `cus_no`, `gender`, `karne_no`, `p_birth`, `p_name`, `p_race`, `p_type`, `pcolor`, `spayed`) VALUES
(1, 5, 1, 1, 55, '2013-09-22 00:20:15', 'Mutlu ', 'CESKY TERRİER', 'Köpek', 'Kahverengi', b'1'),
(2, 9, 1, 1, 3, '2020-04-12 03:00:00', 'Peri', 'Leonberger', 'Köpek', 'Siyah', b'0'),
(3, 6, 2, 2, 23, '2016-10-11 03:00:00', 'Paşa', 'SWEDİSH VALLHOUND', 'Köpek', 'Gri-Kahverengi', b'0'),
(4, 19, 3, 2, 47, '2017-09-11 00:20:04', 'Şans', 'MUNCHKİN', 'Kedi', 'Sarı', b'1'),
(5, 57, 6, 2, 55, '2007-09-30 03:00:00', 'Gece', 'Thoroughbred', 'At', 'Siyah', b'0'),
(6, 21, 4, 1, 21, '2012-06-20 03:00:00', 'Akkız', 'Sığır', 'Büyükbaş', 'Beyaz-Sarı', b'0'),
(7, 13, 5, 2, 65, '2015-08-28 01:17:23', 'Kara', 'Savannah', 'Kedi', 'Siyah-Gri', b'1'),
(8, 77, 5, 2, 66, '2019-09-06 03:00:00', 'Sirius', 'Nebelung', 'Kedi', 'Gri', b'1'),
(9, 190, 10, 2, 190, '2021-09-23 03:00:00', 'Pamuk', 'Tekir', 'Kedi', 'Beyaz', b'1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `box`
--

CREATE TABLE `box` (
  `box_id` int(11) NOT NULL,
  `retail_pro_search` int(11) NOT NULL,
  `sales_note` varchar(255) DEFAULT NULL,
  `sales_product_amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `box`
--

INSERT INTO `box` (`box_id`, `retail_pro_search`, `sales_note`, `sales_product_amount`) VALUES
(1, 1, 'Sargı bezi 10 tane', 10),
(2, 2, 'Gençlik aşısı satıldı', 5);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `box_customer`
--

CREATE TABLE `box_customer` (
  `bc_id` int(11) NOT NULL,
  `box_customer_amount` int(11) NOT NULL,
  `customer_name` int(11) NOT NULL,
  `customer_note` varchar(255) DEFAULT NULL,
  `product_name` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `box_customer`
--

INSERT INTO `box_customer` (`bc_id`, `box_customer_amount`, `customer_name`, `customer_note`, `product_name`) VALUES
(1, 10, 8, 'hıug', 2),
(2, 20, 1, 'Ayşe sargı bezi aldı', 1),
(3, 2, 5, 'Deniz Oyuncak aldı', 8),
(4, 100, 7, 'Ağrı kesici alındı', 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `buying`
--

CREATE TABLE `buying` (
  `bid` int(11) NOT NULL,
  `bill_number` varchar(255) DEFAULT NULL,
  `buying_note` varchar(255) DEFAULT NULL,
  `buying_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `process` int(11) NOT NULL,
  `product_name` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `buying`
--

INSERT INTO `buying` (`bid`, `bill_number`, `buying_note`, `buying_date`, `name`, `process`, `product_name`, `total`) VALUES
(1, '46', 'Erkana satıldı', '2021-09-25 03:00:00', '4', 1, 2, 1840),
(3, '65', 'satıldı', '2021-09-26 03:00:00', '1', 2, 1, 368),
(4, '87', 'canan oyuncak', '2021-09-26 03:00:00', '3', 3, 8, 5520);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `calendar_info`
--

CREATE TABLE `calendar_info` (
  `cid` int(11) NOT NULL,
  `cbg_color` varchar(255) DEFAULT NULL,
  `cborder_color` varchar(255) DEFAULT NULL,
  `ccolor` varchar(255) DEFAULT NULL,
  `cdrag_bg_color` varchar(255) DEFAULT NULL,
  `cname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `calendar_info`
--

INSERT INTO `calendar_info` (`cid`, `cbg_color`, `cborder_color`, `ccolor`, `cdrag_bg_color`, `cname`) VALUES
(1, '#9e5fff', '#9e5fff', '#ffffff', '#9e5fff', 'Randevu'),
(2, '#00a9ff', '#00a9ff', '#ffffff', '#00a9ff', 'Mübesil'),
(3, '#bbdc00', '#bbdc00', '#ffffff', '#bbdc00', 'Hasta'),
(4, '#ffbb3b', '#ffbb3b', '#ffffff', '#ffbb3b', 'Kişisel Takvim');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `category_group`
--

CREATE TABLE `category_group` (
  `cg_id` int(11) NOT NULL,
  `cg_name` varchar(255) DEFAULT NULL,
  `cg_status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `category_group`
--

INSERT INTO `category_group` (`cg_id`, `cg_name`, `cg_status`) VALUES
(1, 'Aşı', b'1'),
(2, 'Vitamin', b'1'),
(3, ' Sağlık Malzemleri', b'1'),
(4, ' Mama', b'1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customer`
--

CREATE TABLE `customer` (
  `cid` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `c_code` varchar(255) DEFAULT NULL,
  `c_email` varchar(255) DEFAULT NULL,
  `c_mobile_phone` varchar(255) DEFAULT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `c_no` varchar(255) DEFAULT NULL,
  `c_note` varchar(255) DEFAULT NULL,
  `c_phone` varchar(255) DEFAULT NULL,
  `c_surname` varchar(255) DEFAULT NULL,
  `il` varchar(255) DEFAULT NULL,
  `ilce` varchar(255) DEFAULT NULL,
  `tax_administration` varchar(255) DEFAULT NULL,
  `tc_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `customer`
--

INSERT INTO `customer` (`cid`, `address`, `c_code`, `c_email`, `c_mobile_phone`, `c_name`, `c_no`, `c_note`, `c_phone`, `c_surname`, `il`, `ilce`, `tax_administration`, `tc_no`) VALUES
(1, '', '', 'aa@mail.com', '966665555', 'Ayşe', '1', '', '25863941', ' Pot', 'İzmir', 'Alsancak', 'A', '55555555'),
(2, 'Beşiktaş/İstanbul', '', 'zehra@mail.com', '851461', 'Zehra', '2', 'Kuduz aşısı yapılacaktır.', '45464646', ' Gök', 'İstanbul', 'Beşiktaş', 'B', '98562222'),
(3, 'A Mahallesi Sk:5854', '', 'k@mail.com', '', 'Kemal', '3', 'Vitamin aşısı yapılacaktır.', '9585224145', ' Zaman', 'Ankara', '', 'A', '847474848'),
(4, ' İstanbul/Kadıköy', ' ', 'ss@mail.com', ' ', ' Şakir', '4', 'Kontrol', '52561111', ' Kafkas', ' İstanbul', ' Kadıköy', ' B', ' 854845845'),
(5, 'C Mahallesi Sk:9585', ' ', 'deniz@mail.com', '11111111', 'Deniz', '5', 'Kontrol', '202023030', ' Yılmaz', 'Çanakkale', '', 'A', '3333333333'),
(6, '', ' ', 'tt@mail.com', '', 'Tuğberk', '6', 'At Vebası ', '54152151', ' Ok', 'Antalya', '', '', '33252333'),
(7, 'K Mahallesi Sk:9595', '', 'su@mail.com', '', 'Su', '7', 'Gençlik Aşısı yapılacak', '12451564', ' Yaz', 'Aydın', 'Efeler', 'A', '6512561256'),
(8, '', '', 'ilyada@mail.com', '', 'İlayda', '10', 'sdfs', '8798796', 'Güler', 'İstanbul', '', 'jfghfgj', '968978');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customer_pay_sale`
--

CREATE TABLE `customer_pay_sale` (
  `cp_id` int(11) NOT NULL,
  `box_cus_date` datetime DEFAULT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `customer_bill_number` int(11) NOT NULL,
  `customer_process` int(11) NOT NULL,
  `sale_boxtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `customer_pay_sale`
--

INSERT INTO `customer_pay_sale` (`cp_id`, `box_cus_date`, `c_name`, `customer_bill_number`, `customer_process`, `sale_boxtotal`) VALUES
(2, '2021-09-25 03:00:00', 'İlayda', 23, 1, 920),
(3, '2021-09-26 03:00:00', 'Ayşe', 25, 2, 460),
(4, '2021-09-27 03:00:00', 'Deniz', 90, 3, 368),
(5, '2021-09-26 03:00:00', 'Su', 67, 3, 12300);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `depo`
--

CREATE TABLE `depo` (
  `depo_id` int(11) NOT NULL,
  `depo_name` varchar(255) DEFAULT NULL,
  `depo_status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `depo`
--

INSERT INTO `depo` (`depo_id`, `depo_name`, `depo_status`) VALUES
(1, 'Ana Depo', b'1'),
(2, 'K', b'0');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `farm_stock`
--

CREATE TABLE `farm_stock` (
  `fsid` int(11) NOT NULL,
  `farm_vac` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `warehouse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `farm_stock`
--

INSERT INTO `farm_stock` (`fsid`, `farm_vac`, `number`, `warehouse`) VALUES
(1, 1, 100, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `farm_vaccine`
--

CREATE TABLE `farm_vaccine` (
  `farm_vaccine_id` int(11) NOT NULL,
  `category_group_id` int(11) NOT NULL,
  `farm_vaccine_amount_fixed` bit(1) NOT NULL,
  `farm_vaccine_barcode` int(11) NOT NULL,
  `farm_vaccine_buying` int(11) NOT NULL,
  `farm_vaccine_buying_kdv` bit(1) NOT NULL,
  `farm_vaccine_code` int(11) NOT NULL,
  `farm_vaccine_kdv` int(11) NOT NULL,
  `farm_vaccine_name` varchar(255) DEFAULT NULL,
  `farm_vaccine_sales` int(11) NOT NULL,
  `farm_vaccine_sales_kdv` bit(1) NOT NULL,
  `farm_vaccine_status` bit(1) NOT NULL,
  `farm_vaccine_stock` int(11) NOT NULL,
  `farm_vaccine_tip` varchar(255) DEFAULT NULL,
  `farm_vaccine_type` varchar(255) DEFAULT NULL,
  `farm_vaccine_unit` varchar(255) DEFAULT NULL,
  `vendor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `farm_vaccine`
--

INSERT INTO `farm_vaccine` (`farm_vaccine_id`, `category_group_id`, `farm_vaccine_amount_fixed`, `farm_vaccine_barcode`, `farm_vaccine_buying`, `farm_vaccine_buying_kdv`, `farm_vaccine_code`, `farm_vaccine_kdv`, `farm_vaccine_name`, `farm_vaccine_sales`, `farm_vaccine_sales_kdv`, `farm_vaccine_status`, `farm_vaccine_stock`, `farm_vaccine_tip`, `farm_vaccine_type`, `farm_vaccine_unit`, `vendor_id`) VALUES
(1, 1, b'0', 10, 90, b'1', 10, 1, 'Çiftlik Vak', 150, b'0', b'0', 50, '2', '', '2', 2),
(2, 2, b'0', 8, 150, b'0', 8, 1, 'Çiftlik Vac22', 200, b'0', b'0', 50, '2', '', '1', 5);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `laboratuvar`
--

CREATE TABLE `laboratuvar` (
  `lid` int(11) NOT NULL,
  `animal_name` int(11) NOT NULL,
  `diagnosis` varchar(255) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `lab_type` int(11) NOT NULL,
  `cus_no` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `laboratuvar`
--

INSERT INTO `laboratuvar` (`lid`, `animal_name`, `diagnosis`, `image_name`, `lab_type`, `cus_no`) VALUES
(1, 3, 'Yabancı cisim tespit edildi.', NULL, 2, 0),
(3, 5, 'sdfghj', NULL, 2, 0),
(4, 3, '', 'C:\\fakepath\\rontgen.jpg', 2, 0),
(5, 7, '', 'C:\\fakepath\\rontgn.jpg', 1, 0),
(8, 4, 'jkhkl', '', 1, 0),
(17, 1, 'yjgh', '6cca094f-4a61-4e64-bdcf-3c9e2ccb7b54o.jpg', 2, 1),
(19, 9, 'thrbb', 'a2c70372-55c2-462c-b234-3392feb28628o.jpg', 2, 10);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `new_case`
--

CREATE TABLE `new_case` (
  `case_id` int(11) NOT NULL,
  `case_name` varchar(255) DEFAULT NULL,
  `case_status` bit(1) NOT NULL,
  `case_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `new_case`
--

INSERT INTO `new_case` (`case_id`, `case_name`, `case_status`, `case_type`) VALUES
(1, 'A', b'1', '1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `pet_stock`
--

CREATE TABLE `pet_stock` (
  `psid` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `depo` int(11) NOT NULL,
  `pet_vac` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `pet_stock`
--

INSERT INTO `pet_stock` (`psid`, `amount`, `depo`, `pet_vac`) VALUES
(1, 60, 1, 1),
(2, 100, 1, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `pet_vaccine`
--

CREATE TABLE `pet_vaccine` (
  `pet_vaccine_id` int(11) NOT NULL,
  `category_group_cg_id` int(11) NOT NULL,
  `pet_vaccine_amount_fixed` bit(1) NOT NULL,
  `pet_vaccine_barcode` int(11) NOT NULL,
  `pet_vaccine_buying` int(11) NOT NULL,
  `pet_vaccine_buying_kdv` bit(1) NOT NULL,
  `pet_vaccine_code` int(11) NOT NULL,
  `pet_vaccine_kdv` int(11) NOT NULL,
  `pet_vaccine_name` varchar(255) DEFAULT NULL,
  `pet_vaccine_number` int(11) NOT NULL,
  `pet_vaccine_sales` int(11) NOT NULL,
  `pet_vaccine_sales_kdv` bit(1) NOT NULL,
  `pet_vaccine_status` bit(1) NOT NULL,
  `pet_vaccine_stock` int(11) NOT NULL,
  `pet_vaccine_tip` varchar(255) DEFAULT NULL,
  `pet_vaccine_type` varchar(255) DEFAULT NULL,
  `pet_vaccine_unit` varchar(255) DEFAULT NULL,
  `vendor_vid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `pet_vaccine`
--

INSERT INTO `pet_vaccine` (`pet_vaccine_id`, `category_group_cg_id`, `pet_vaccine_amount_fixed`, `pet_vaccine_barcode`, `pet_vaccine_buying`, `pet_vaccine_buying_kdv`, `pet_vaccine_code`, `pet_vaccine_kdv`, `pet_vaccine_name`, `pet_vaccine_number`, `pet_vaccine_sales`, `pet_vaccine_sales_kdv`, `pet_vaccine_status`, `pet_vaccine_stock`, `pet_vaccine_tip`, `pet_vaccine_type`, `pet_vaccine_unit`, `vendor_vid`) VALUES
(1, 1, b'0', 66, 50, b'1', 2, 8, 'Gençlik Aşısı', 2, 100, b'1', b'1', 100, '3', '', '1', 3),
(2, 1, b'0', 6, 200, b'0', 6, 1, 'pet vacc1', 2, 250, b'0', b'0', 50, '1', '', '2', 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `category_group_cg_id` int(11) NOT NULL,
  `product_amount_fixed` bit(1) NOT NULL,
  `product_barcode` int(11) NOT NULL,
  `product_buying` int(11) NOT NULL,
  `product_buying_kdv` bit(1) NOT NULL,
  `product_code` int(11) NOT NULL,
  `product_kdv` int(11) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_sales` int(11) NOT NULL,
  `product_sales_kdv` bit(1) NOT NULL,
  `product_status` bit(1) NOT NULL,
  `product_stock` int(11) NOT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `product_unit` varchar(255) DEFAULT NULL,
  `vendor_vid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `product`
--

INSERT INTO `product` (`product_id`, `category_group_cg_id`, `product_amount_fixed`, `product_barcode`, `product_buying`, `product_buying_kdv`, `product_code`, `product_kdv`, `product_name`, `product_sales`, `product_sales_kdv`, `product_status`, `product_stock`, `product_type`, `product_unit`, `vendor_vid`) VALUES
(1, 1, b'0', 2, 20, b'0', 5, 8, 'Sargı Bezi', 25, b'1', b'1', 50, '2', '1', 1),
(2, 1, b'1', 9, 50, b'0', 1, 8, 'Gençlik Aşısı', 100, b'0', b'1', 100, '2', '3', 4),
(3, 3, b'0', 32, 100, b'1', 3, 18, 'Ağrı Kesici', 150, b'1', b'1', 13, '2', '1', 4),
(8, 3, b'0', 34, 150, b'0', 34, 8, 'Oyuncak', 200, b'1', b'0', 30, '3', '2', 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `retail_sale`
--

CREATE TABLE `retail_sale` (
  `rid` int(11) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `sale_date` datetime DEFAULT NULL,
  `sale_process` int(11) NOT NULL,
  `saletotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `retail_sale`
--

INSERT INTO `retail_sale` (`rid`, `product_name`, `sale_date`, `sale_process`, `saletotal`) VALUES
(1, 'Sargı Bezi', '2021-09-25 03:00:00', 1, 230),
(2, 'Gençlik Aşısı', '2021-09-25 03:00:00', 1, 460);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_CUSTOMER'),
(2, 'ROLE_ADMIN'),
(3, 'ROLE_DOCTOR'),
(4, 'ROLE_SECRETARY');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `schedule_calendar`
--

CREATE TABLE `schedule_calendar` (
  `sid` int(11) NOT NULL,
  `bg_color` varchar(255) DEFAULT NULL,
  `border_color` varchar(255) DEFAULT NULL,
  `calendar_id` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `drag_bg_color` varchar(255) DEFAULT NULL,
  `due_date_class` varchar(255) DEFAULT NULL,
  `end` varchar(255) DEFAULT NULL,
  `id` varchar(255) DEFAULT NULL,
  `is_all_day` bit(1) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `raw` varchar(255) DEFAULT NULL,
  `start` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `schedule_calendar`
--

INSERT INTO `schedule_calendar` (`sid`, `bg_color`, `border_color`, `calendar_id`, `category`, `color`, `drag_bg_color`, `due_date_class`, `end`, `id`, `is_all_day`, `location`, `raw`, `start`, `state`, `title`) VALUES
(7, '#00a9ff', '#00a9ff', '2', 'time', '#ffffff', '#00a9ff', '', 'Wed Sep 22 2021 14:30:00 GMT+0300 (GMT+03:00)', 'daaa0fc1-05d0-5ec3-aec0-838d89598677', b'0', 'İstanbul', 'public', 'Wed Sep 22 2021 13:30:00 GMT+0300 (GMT+03:00)', 'Busy', 'İlaç'),
(8, '#ffbb3b', '#ffbb3b', '4', 'time', '#ffffff', '#ffbb3b', '', 'Thu Sep 23 2021 18:30:00 GMT+0300 (GMT+03:00)', '95995834-5bb3-5e2e-b981-21aa0616035f', b'0', 'İstanbul', 'public', 'Thu Sep 23 2021 12:00:00 GMT+0300 (GMT+03:00)', 'Busy', 'Sinema'),
(9, '#ffbb3b', '#ffbb3b', '4', 'allday', '#ffffff', '#ffbb3b', '', 'Fri Sep 24 2021 23:59:59 GMT+0300 (GMT+03:00)', '67cbcf88-fd67-5d8e-87ff-0118b5bf70fb', b'1', 'İstanbul', 'public', 'Fri Sep 24 2021 00:00:00 GMT+0300 (GMT+03:00)', 'Free', 'Tatil'),
(11, '#bbdc00', '#bbdc00', '3', 'time', '#ffffff', '#bbdc00', '', 'Sat Sep 25 2021 12:30:00 GMT+0300 (GMT+03:00)', '71ca5538-8193-5467-aeb3-c8b8ad693f3d', NULL, 'poopo', 'public', 'Sat Sep 25 2021 09:00:00 GMT+0300 (GMT+03:00)', 'Busy', 'Hasta Randevu'),
(12, '#00a9ff', '#00a9ff', '2', 'time', '#ffffff', '#00a9ff', '', 'Thu Sep 23 2021 07:30:00 GMT+0300 (GMT+03:00)', '0e94a32a-2c55-55d6-9c31-51e7b62aa5e4', b'0', 'İstanbul', 'public', 'Thu Sep 23 2021 04:30:00 GMT+0300 (GMT+03:00)', 'Busy', 'İlaç Alma'),
(13, '#9e5fff', '#9e5fff', '1', 'time', '#ffffff', '#9e5fff', '', 'Sat Sep 25 2021 04:00:00 GMT+0300 (GMT+03:00)', 'a42cfadd-cb48-56d3-a249-d1ecd76794c4', b'0', 'Ankara', 'public', 'Sat Sep 25 2021 00:30:00 GMT+0300 (GMT+03:00)', 'Busy', 'Hasta Randevu');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `stock`
--

CREATE TABLE `stock` (
  `sid` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `depo` int(11) NOT NULL,
  `product` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `stock`
--

INSERT INTO `stock` (`sid`, `amount`, `depo`, `product`) VALUES
(2, 40, 1, 2),
(3, 50, 1, 3),
(5, 20, 1, 1),
(6, 40, 1, 8);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `token_expired` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `phone`, `status`, `token_expired`) VALUES
(1, 'ali@gmail.com', b'1', 'Ali', 'Bilmem', '$2a$10$RZ1xEc3MSJiJreBBSIhsse9Io0KZrwZi.cZ.bvofImxAgJMmzfLhe', '78578567', b'0', b'1'),
(2, 'veli@mail.com', b'1', 'Veli', 'Yaz', '$2a$10$QwOUJGsTUheHwQZN9XTGeeUTEz3VvW2IEs3wLeLh3kdpGjFxanEpW', '535656', b'0', b'1'),
(3, 'demet@mail.com', b'1', 'Demet', 'Koçhan', '$2a$10$z//wMb9FcCSJbiAyUpU7s.Rh5CLuTiG/pP6O4Hj4w/wOGz/.F9.xC', '564564', b'0', b'1'),
(4, 'kenan@mail.com', b'1', 'Kenan', 'Yılmaz', '$2a$10$8uavAMA6SUFQDssVmCpYquIFqon250MKrMg2j8L//fMW5t3z2ZtWu', '986678', b'0', b'1'),
(5, 'zehra@mail.com', b'1', 'Zehra', 'Kaya', '$2a$10$xkCqqYpmYMOm6TirGpJiRu3Uea6VQNsZ4KCq3D28FXGDeKwKLCTku', '78585857', b'0', b'1'),
(6, 'serkan@mail.com', b'1', 'Serkan', 'Kaya', '$2a$10$f1TcuqbGb.Bj2RkYp80o3uE86/vrXg8BSgGeMoMRoXfpC41vPG2Ge', '09876', b'0', b'1'),
(7, 'ilayda@mail.com', b'1', 'ilayda', 'güler', '$2a$10$.dyxQgnhv8DS6SMkoU544uXRICCSfPvGllVRqt3rzIO2n/MSoN9a.', '425425', b'0', b'1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 3),
(5, 2),
(6, 3),
(7, 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `vendor`
--

CREATE TABLE `vendor` (
  `vid` int(11) NOT NULL,
  `vendor_email` varchar(255) DEFAULT NULL,
  `vendor_name` varchar(255) DEFAULT NULL,
  `vendor_phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `vendor`
--

INSERT INTO `vendor` (`vid`, `vendor_email`, `vendor_name`, `vendor_phone`) VALUES
(1, 'kerem@mail.com', 'A', '4864864865'),
(3, 'cnn@mail.com', 'Canan', '888888'),
(4, 'erkan@mail.com', 'Erkan', '555555'),
(5, 'zzzz@mail.com', 'Zeki', '95959');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`aid`);

--
-- Tablo için indeksler `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`aid`),
  ADD UNIQUE KEY `UK_io8tye9u1sq921yfel0r7uibh` (`cip_no`);

--
-- Tablo için indeksler `box`
--
ALTER TABLE `box`
  ADD PRIMARY KEY (`box_id`);

--
-- Tablo için indeksler `box_customer`
--
ALTER TABLE `box_customer`
  ADD PRIMARY KEY (`bc_id`);

--
-- Tablo için indeksler `buying`
--
ALTER TABLE `buying`
  ADD PRIMARY KEY (`bid`);

--
-- Tablo için indeksler `calendar_info`
--
ALTER TABLE `calendar_info`
  ADD PRIMARY KEY (`cid`);

--
-- Tablo için indeksler `category_group`
--
ALTER TABLE `category_group`
  ADD PRIMARY KEY (`cg_id`);

--
-- Tablo için indeksler `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cid`);

--
-- Tablo için indeksler `customer_pay_sale`
--
ALTER TABLE `customer_pay_sale`
  ADD PRIMARY KEY (`cp_id`);

--
-- Tablo için indeksler `depo`
--
ALTER TABLE `depo`
  ADD PRIMARY KEY (`depo_id`);

--
-- Tablo için indeksler `farm_stock`
--
ALTER TABLE `farm_stock`
  ADD PRIMARY KEY (`fsid`);

--
-- Tablo için indeksler `farm_vaccine`
--
ALTER TABLE `farm_vaccine`
  ADD PRIMARY KEY (`farm_vaccine_id`);

--
-- Tablo için indeksler `laboratuvar`
--
ALTER TABLE `laboratuvar`
  ADD PRIMARY KEY (`lid`);

--
-- Tablo için indeksler `new_case`
--
ALTER TABLE `new_case`
  ADD PRIMARY KEY (`case_id`);

--
-- Tablo için indeksler `pet_stock`
--
ALTER TABLE `pet_stock`
  ADD PRIMARY KEY (`psid`);

--
-- Tablo için indeksler `pet_vaccine`
--
ALTER TABLE `pet_vaccine`
  ADD PRIMARY KEY (`pet_vaccine_id`);

--
-- Tablo için indeksler `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Tablo için indeksler `retail_sale`
--
ALTER TABLE `retail_sale`
  ADD PRIMARY KEY (`rid`);

--
-- Tablo için indeksler `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `schedule_calendar`
--
ALTER TABLE `schedule_calendar`
  ADD PRIMARY KEY (`sid`);

--
-- Tablo için indeksler `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`sid`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  ADD KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`);

--
-- Tablo için indeksler `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`vid`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `agenda`
--
ALTER TABLE `agenda`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `animal`
--
ALTER TABLE `animal`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `box`
--
ALTER TABLE `box`
  MODIFY `box_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `box_customer`
--
ALTER TABLE `box_customer`
  MODIFY `bc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `buying`
--
ALTER TABLE `buying`
  MODIFY `bid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `calendar_info`
--
ALTER TABLE `calendar_info`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `category_group`
--
ALTER TABLE `category_group`
  MODIFY `cg_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `customer`
--
ALTER TABLE `customer`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `customer_pay_sale`
--
ALTER TABLE `customer_pay_sale`
  MODIFY `cp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `depo`
--
ALTER TABLE `depo`
  MODIFY `depo_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `farm_stock`
--
ALTER TABLE `farm_stock`
  MODIFY `fsid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `farm_vaccine`
--
ALTER TABLE `farm_vaccine`
  MODIFY `farm_vaccine_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `laboratuvar`
--
ALTER TABLE `laboratuvar`
  MODIFY `lid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Tablo için AUTO_INCREMENT değeri `new_case`
--
ALTER TABLE `new_case`
  MODIFY `case_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `pet_stock`
--
ALTER TABLE `pet_stock`
  MODIFY `psid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `pet_vaccine`
--
ALTER TABLE `pet_vaccine`
  MODIFY `pet_vaccine_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `retail_sale`
--
ALTER TABLE `retail_sale`
  MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `schedule_calendar`
--
ALTER TABLE `schedule_calendar`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Tablo için AUTO_INCREMENT değeri `stock`
--
ALTER TABLE `stock`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `vendor`
--
ALTER TABLE `vendor`
  MODIFY `vid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
