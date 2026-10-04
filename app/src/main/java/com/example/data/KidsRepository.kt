package com.example.data

object KidsRepository {

    val categories = listOf(
        Category("alphabets_en", "English A-Z", "अंग्रेजी A-Z", "इंग्रजी A-Z", "🔤", "#FF6B6B"),
        Category("hindi_swar", "Hindi Swar (स्वर)", "हिंदी स्वर", "हिंदी स्वर", "अ", "#FF8400"),
        Category("hindi_vyanjan", "Hindi Vyanjan (व्यंजन)", "हिंदी व्यंजन", "हिंदी व्यंजन", "क", "#4D96FF"),
        Category("hindi_barakhadi", "Hindi Barakhadi", "हिंदी बारहखड़ी", "हिंदी बारहखड़ी", "क का", "#6BCB77"),
        Category("marathi_swar", "Marathi Swar (स्वर)", "मराठी स्वर", "मराठी स्वर", "अ", "#9370DB"),
        Category("marathi_vyanjan", "Marathi Vyanjan (व्यंजन)", "मराठी व्यंजन", "मराठी व्यंजने", "क", "#FF5C8D"),
        Category("marathi_barakhadi", "Marathi Barakhadi", "मराठी बाराखडी", "मराठी बाराखडी", "क का", "#00C49F"),
        Category("numbers", "Numbers (1-20)", "गिनती (1-20)", "अंक (1-20)", "🔢", "#FFD93D"),
        Category("shapes", "Shapes", "आकार", "आकार", "⭐", "#6BCB77"),
        Category("colors", "Colors", "रंग", "रंग", "🎨", "#FF4136"),
        Category("days", "Days of Week", "सप्ताह के दिन", "आठवड्याचे वार", "📅", "#0074D9"),
        Category("english_months", "English Months", "अंग्रेजी महीने", "इंग्रजी महिने", "🗓️", "#B10DC9"),
        Category("indian_months", "Indian Months", "भारतीय महीने", "भारतीय महिने", "🪔", "#FF851B"),
        Category("fruits_veg", "Fruits & Veg", "फल और सब्जियां", "फळे आणि भाज्या", "🍎", "#2ECC40"),
        Category("animals_birds", "Animals & Birds", "पशु और पक्षी", "प्राणी आणि पक्षी", "🦁", "#FF6B6B"),
        Category("vehicles", "Vehicles", "वाहन", "वाहतूक साधने", "🚗", "#4D96FF")
    )

    // Pure English A-Z with ZERO Hindi/Marathi script overlapping
    val englishAlphabets = listOf(
        LearningItem("a", "A for Apple", "A for Apple", "A for Apple", "Apple", "", "", "🍎", "alphabets_en", "#FF6B6B"),
        LearningItem("b", "B for Ball", "B for Ball", "B for Ball", "Ball", "", "", "⚽", "alphabets_en", "#4D96FF"),
        LearningItem("c", "C for Cat", "C for Cat", "C for Cat", "Cat", "", "", "🐱", "alphabets_en", "#6BCB77"),
        LearningItem("d", "D for Doll", "D for Doll", "D for Doll", "Doll", "", "", "🪆", "alphabets_en", "#FFD93D"),
        LearningItem("e", "E for Elephant", "E for Elephant", "E for Elephant", "Elephant", "", "", "🐘", "alphabets_en", "#9370DB"),
        LearningItem("f", "F for Fish", "F for Fish", "F for Fish", "Fish", "", "", "🐟", "alphabets_en", "#FF8400"),
        LearningItem("g", "G for Grapes", "G for Grapes", "G for Grapes", "Grapes", "", "", "🍇", "alphabets_en", "#00C49F"),
        LearningItem("h", "H for Hat", "H for Hat", "H for Hat", "Hat", "", "", "🎩", "alphabets_en", "#FF5C8D"),
        LearningItem("i", "I for Ice cream", "I for Ice cream", "I for Ice cream", "Ice cream", "", "", "🍦", "alphabets_en", "#FF6B6B"),
        LearningItem("j", "J for Jug", "J for Jug", "J for Jug", "Jug", "", "", "🏺", "alphabets_en", "#4D96FF"),
        LearningItem("k", "K for Kite", "K for Kite", "K for Kite", "Kite", "", "", "🪁", "alphabets_en", "#6BCB77"),
        LearningItem("l", "L for Lion", "L for Lion", "L for Lion", "Lion", "", "", "🦁", "alphabets_en", "#FFD93D"),
        LearningItem("m", "M for Mango", "M for Mango", "M for Mango", "Mango", "", "", "🥭", "alphabets_en", "#9370DB"),
        LearningItem("n", "N for Nest", "N for Nest", "N for Nest", "Nest", "", "", "🪺", "alphabets_en", "#FF8400"),
        LearningItem("o", "O for Orange", "O for Orange", "O for Orange", "Orange", "", "", "🍊", "alphabets_en", "#00C49F"),
        LearningItem("p", "P for Parrot", "P for Parrot", "P for Parrot", "Parrot", "", "", "🦜", "alphabets_en", "#FF5C8D"),
        LearningItem("q", "Q for Queen", "Q for Queen", "Q for Queen", "Queen", "", "", "👑", "alphabets_en", "#FF6B6B"),
        LearningItem("r", "R for Rabbit", "R for Rabbit", "R for Rabbit", "Rabbit", "", "", "🐰", "alphabets_en", "#4D96FF"),
        LearningItem("s", "S for Sun", "S for Sun", "S for Sun", "Sun", "", "", "☀️", "alphabets_en", "#6BCB77"),
        LearningItem("t", "T for Train", "T for Train", "T for Train", "Train", "", "", "🚂", "alphabets_en", "#FFD93D"),
        LearningItem("u", "U for Umbrella", "U for Umbrella", "U for Umbrella", "Umbrella", "", "", "🌂", "alphabets_en", "#9370DB"),
        LearningItem("v", "V for Van", "V for Van", "V for Van", "Van", "", "", "🚐", "alphabets_en", "#FF8400"),
        LearningItem("w", "W for Watch", "W for Watch", "W for Watch", "Watch", "", "", "⌚", "alphabets_en", "#00C49F"),
        LearningItem("x", "X for Xylophone", "X for Xylophone", "X for Xylophone", "Xylophone", "", "", "🪗", "alphabets_en", "#FF5C8D"),
        LearningItem("y", "Y for Yak", "Y for Yak", "Y for Yak", "Yak", "", "", "🐃", "alphabets_en", "#FF6B6B"),
        LearningItem("z", "Z for Zebra", "Z for Zebra", "Z for Zebra", "Zebra", "", "", "🦓", "alphabets_en", "#4D96FF")
    )

    val hindiSwar = listOf(
        LearningItem("h_swar_1", "अ से अनार", "अ से अनार", "अ (अनार)", "Pomegranate", "अनार", "अनार", "🍎", "hindi_swar", "#FF6B6B"),
        LearningItem("h_swar_2", "आ से आम", "आ से आम", "आ (आम)", "Mango", "आम", "आम", "🥭", "hindi_swar", "#FF8400"),
        LearningItem("h_swar_3", "इ से इमली", "इ से इमली", "इ (इमली)", "Tamarind", "इमली", "इमली", "🌿", "hindi_swar", "#FFD93D"),
        LearningItem("h_swar_4", "ई से ईख", "ई से ईख", "ई (ईख)", "Sugarcane", "ईख", "ऊस", "🌾", "hindi_swar", "#6BCB77"),
        LearningItem("h_swar_5", "उ से उल्लू", "उ से उल्लू", "उ (उल्लू)", "Owl", "उल्लू", "घुबड", "🦉", "hindi_swar", "#4D96FF"),
        LearningItem("h_swar_6", "ऊ से ऊन", "ऊ से ऊन", "ऊ (ऊन)", "Wool", "ऊन", "लोकर", "🧶", "hindi_swar", "#9370DB"),
        LearningItem("h_swar_7", "ऋ से ऋषि", "ऋ से ऋषि", "ऋ (ऋषि)", "Sage", "ऋषि", "ऋषी", "🧘", "hindi_swar", "#FF5C8D"),
        LearningItem("h_swar_8", "ए से एड़ी", "ए से एड़ी", "ए (एडी)", "Heel", "एड़ी", "टाच", "🦶", "hindi_swar", "#00C49F"),
        LearningItem("h_swar_9", "ऐ से ऐनक", "ऐ से ऐनक", "ऐ (ऐनक)", "Spectacles", "ऐनक", "चष्मा", "👓", "hindi_swar", "#FF6B6B"),
        LearningItem("h_swar_10", "ओ से ओखली", "ओ से ओखली", "ओ (ओखली)", "Mortar", "ओखली", "खलबत्ता", "🥣", "hindi_swar", "#4D96FF"),
        LearningItem("h_swar_11", "औ से औरत", "औ से औरत", "औ (औरत)", "Woman", "औरत", "स्त्री", "👩", "hindi_swar", "#6BCB77"),
        LearningItem("h_swar_12", "अं से अंगूर", "अं से अंगूर", "अं (अंगूर)", "Grapes", "अंगूर", "द्रेक्ष", "🍇", "hindi_swar", "#FFD93D"),
        LearningItem("h_swar_13", "अः खाली", "अः खाली", "अः", "Empty", "खाली", "रिकामी", "😊", "hindi_swar", "#9370DB")
    )

    val hindiVyanjan = listOf(
        LearningItem("h_v_1", "क से कमल", "क से कमल", "क (कमल)", "Lotus", "कमल", "कमळ", "🪷", "hindi_vyanjan", "#FF6B6B"),
        LearningItem("h_v_2", "ख से खरगोश", "ख से खरगोश", "ख (खरगोश)", "Rabbit", "खरगोश", "ससा", "🐰", "hindi_vyanjan", "#4D96FF"),
        LearningItem("h_v_3", "ग से गमला", "ग से गमला", "ग (गमला)", "Pot", "गमला", "फुलदाणी", "🏺", "hindi_vyanjan", "#6BCB77"),
        LearningItem("h_v_4", "घ से घर", "घ से घर", "घ (घर)", "House", "घर", "घर", "🏠", "hindi_vyanjan", "#FFD93D"),
        LearningItem("h_v_5", "च से चम्मच", "च से चम्मच", "च (चम्मच)", "Spoon", "चम्मच", "चामचा", "🥄", "hindi_vyanjan", "#9370DB"),
        LearningItem("h_v_6", "छ से छाता", "छ से छाता", "छ (छाता)", "Umbrella", "छाता", "छत्री", "🌂", "hindi_vyanjan", "#FF8400"),
        LearningItem("h_v_7", "ज से जहाज", "ज से जहाज", "ज (जहाज)", "Ship", "जहाज", "जहाज", "🚢", "hindi_vyanjan", "#00C49F"),
        LearningItem("h_v_8", "झ से झंडा", "झ से झंडा", "झ (झंडा)", "Flag", "झंडा", "झेंडा", "🇮🇳", "hindi_vyanjan", "#FF5C8D"),
        LearningItem("h_v_9", "ट से टमाटर", "ट से टमाटर", "ट (टमाटर)", "Tomato", "टमाटर", "टोमॅटो", "🍅", "hindi_vyanjan", "#FF6B6B"),
        LearningItem("h_v_10", "ड से डमरू", "ड से डमरू", "ड (डमरू)", "Drum", "डमरू", "डमडू", "🪘", "hindi_vyanjan", "#4D96FF"),
        LearningItem("h_v_11", "त से तरबूज", "त से तरबूज", "त (तरबूज)", "Watermelon", "तरबूज", "कलिंगड", "🍉", "hindi_vyanjan", "#6BCB77"),
        LearningItem("h_v_12", "थ से थर्मस", "थ से थर्मस", "थ (थर्मस)", "Flask", "थर्मस", "थर्मस", "🍼", "hindi_vyanjan", "#FFD93D"),
        LearningItem("h_v_13", "द से दवात", "द से दवात", "द (दवात)", "Inkpot", "दवात", "शाई", "✒️", "hindi_vyanjan", "#9370DB"),
        LearningItem("h_v_14", "ध से धनुष", "ध से धनुष", "ध (धनुष)", "Bow", "धनुष", "धनुष्य", "🏹", "hindi_vyanjan", "#FF8400"),
        LearningItem("h_v_15", "न से नल", "न से नल", "न (नल)", "Tap", "नल", "नळ", "🚰", "hindi_vyanjan", "#00C49F"),
        LearningItem("h_v_16", "प से पतंग", "प से पतंग", "प (पतंग)", "Kite", "पतंग", "पतंग", "🪁", "hindi_vyanjan", "#FF5C8D"),
        LearningItem("h_v_17", "फ से फल", "फ से फल", "फ (फल)", "Fruits", "फल", "फळे", "🍎", "hindi_vyanjan", "#FF6B6B"),
        LearningItem("h_v_18", "ब से बत्तख", "ब से बत्तख", "ब (बत्तख)", "Duck", "बत्तख", "बदक", "🦆", "hindi_vyanjan", "#4D96FF"),
        LearningItem("h_v_19", "भ से भालू", "भ से भालू", "भ (भालू)", "Bear", "भालू", "अस्वल", "🐻", "hindi_vyanjan", "#6BCB77"),
        LearningItem("h_v_20", "म से मछली", "म से मछली", "म (मछली)", "Fish", "मछली", "मासा", "🐟", "hindi_vyanjan", "#FFD93D"),
        LearningItem("h_v_21", "य से यज्ञ", "य से यज्ञ", "य (यज्ञ)", "Fire ritual", "यज्ञ", "यज्ञ", "🔥", "hindi_vyanjan", "#9370DB"),
        LearningItem("h_v_22", "र से रथ", "र से रथ", "र (रथ)", "Chariot", "रथ", "रथ", "🛞", "hindi_vyanjan", "#FF8400"),
        LearningItem("h_v_23", "ल से लट्टू", "ल से लट्टू", "ल (लट्टू)", "Top", "लट्टू", "भोरा", "🪀", "hindi_vyanjan", "#00C49F"),
        LearningItem("h_v_24", "व से वैन", "व से वैन", "व (वैन)", "Van", "वैन", "व्हॅन", "🚐", "hindi_vyanjan", "#FF5C8D")
    )

    val hindiBarakhadi = listOf(
        LearningItem("hb_1", "क - Ka", "क", "क", "Ka", "क", "क", "🔤", "hindi_barakhadi", "#FF6B6B"),
        LearningItem("hb_2", "का - Kaa", "का", "का", "Kaa", "का", "का", "🔤", "hindi_barakhadi", "#4D96FF"),
        LearningItem("hb_3", "कि - Ki", "कि", "कि", "Ki", "कि", "कि", "🔤", "hindi_barakhadi", "#6BCB77"),
        LearningItem("hb_4", "की - Kee", "की", "की", "Kee", "की", "की", "🔤", "hindi_barakhadi", "#FFD93D"),
        LearningItem("hb_5", "कु - Ku", "कु", "कु", "Ku", "कु", "कु", "🔤", "hindi_barakhadi", "#9370DB"),
        LearningItem("hb_6", "कू - Koo", "कू", "कू", "Koo", "कू", "कू", "🔤", "hindi_barakhadi", "#FF8400"),
        LearningItem("hb_7", "के - Ke", "के", "के", "Ke", "के", "के", "🔤", "hindi_barakhadi", "#00C49F"),
        LearningItem("hb_8", "कै - Kai", "कै", "कै", "Kai", "कै", "कै", "🔤", "hindi_barakhadi", "#FF5C8D"),
        LearningItem("hb_9", "को - Ko", "को", "को", "Ko", "को", "को", "🔤", "hindi_barakhadi", "#FF6B6B"),
        LearningItem("hb_10", "कौ - Kau", "कौ", "कौ", "Kau", "कौ", "कौ", "🔤", "hindi_barakhadi", "#4D96FF"),
        LearningItem("hb_11", "कंस - Kam", "कं", "कं", "Kam", "कं", "कं", "🔤", "hindi_barakhadi", "#6BCB77"),
        LearningItem("hb_12", "कः - Kaha", "कः", "कः", "Kaha", "कः", "कः", "🔤", "hindi_barakhadi", "#FFD93D")
    )

    val marathiSwar = listOf(
        LearningItem("ms_1", "अ - अननस", "अ", "अ - अननस (Pineapple)", "Pineapple", "अननस", "अननस", "🍍", "marathi_swar", "#FF6B6B"),
        LearningItem("ms_2", "आ - आंबा", "आ", "आ - आंबा (Mango)", "Mango", "आम", "आंबा", "🥭", "marathi_swar", "#4D96FF"),
        LearningItem("ms_3", "इ - इमारत", "इ", "इ - इमारत (Building)", "Building", "इमारत", "इमारत", "🏢", "marathi_swar", "#6BCB77"),
        LearningItem("ms_4", "ई - ईळ", "ई", "ई - ईस (Sugarcane)", "Sugarcane", "ईख", "ऊस", "🌾", "marathi_swar", "#FFD93D"),
        LearningItem("ms_5", "उ - उंदीर", "उ", "उ - उंदीर (Mouse)", "Mouse", "उंदीर", "उंदीर", "🐁", "marathi_swar", "#9370DB"),
        LearningItem("ms_6", "ऊ - ऊस", "ऊ", "ऊ - ऊस (Sugarcane)", "Sugarcane", "ऊस", "ऊस", "🎋", "marathi_swar", "#FF8400"),
        LearningItem("ms_7", "ऋ - ऋषी", "ऋ", "ऋ - ऋषी (Sage)", "Sage", "ऋषि", "ऋषी", "🧘", "marathi_swar", "#00C49F"),
        LearningItem("ms_8", "ए - एडका", "ए", "ए - एडका (Ram)", "Ram", "एडका", "मेंढा", "🐏", "marathi_swar", "#FF5C8D"),
        LearningItem("ms_9", "ऐ - ऐरणी", "ऐ", "ऐ - ऐरणी (Anvil)", "Anvil", "ऐनक", "ऐरण", "🔨", "marathi_swar", "#FF6B6B"),
        LearningItem("ms_10", "ओ - ओझे", "ओ", "ओ - ओझे (Load)", "Load", "ओझे", "ओझे", "📦", "marathi_swar", "#4D96FF"),
        LearningItem("ms_11", "औ - औषध", "औ", "औ - औषध (Medicine)", "Medicine", "औषध", "औषध", "💊", "marathi_swar", "#6BCB77"),
        LearningItem("ms_12", "अं - अंगույ", "अं", "अं - अंगույ (Grapes)", "Grapes", "अंगूर", "द्रेक्ष", "🍇", "marathi_swar", "#FFD93D")
    )

    val marathiVyanjan = listOf(
        LearningItem("mv_1", "क - कमळ", "क", "क - कमळ (Lotus)", "Lotus", "कमल", "कमळ", "🪷", "marathi_vyanjan", "#FF6B6B"),
        LearningItem("mv_2", "ख - खटारा", "ख", "ख - खटारा (Cart)", "Cart", "खटारा", "गाडी", "🚜", "marathi_vyanjan", "#4D96FF"),
        LearningItem("mv_3", "ग - गणपती", "ग", "ग - गणपती (Ganesha)", "Ganesha", "गणपती", "गणपती बाप्पा", "🛕", "marathi_vyanjan", "#6BCB77"),
        LearningItem("mv_4", "घ - घर", "घ", "घ - घर (House)", "House", "घर", "घर", "🏠", "marathi_vyanjan", "#FFD93D"),
        LearningItem("mv_5", "च - चमचा", "च", "च - चमचा (Spoon)", "Spoon", "चम्मच", "चामचा", "🥄", "marathi_vyanjan", "#9370DB"),
        LearningItem("mv_6", "छ - छत्री", "छ", "छ - छत्री (Umbrella)", "Umbrella", "छाता", "छत्री", "🌂", "marathi_vyanjan", "#FF8400"),
        LearningItem("mv_7", "ज - जहाज", "ज", "ज - जहाज (Ship)", "Ship", "जहाज", "जहाज", "🚢", "marathi_vyanjan", "#00C49F"),
        LearningItem("mv_8", "झ - झेंडा", "झ", "झ - झेंडा (Flag)", "Flag", "झंडा", "झेंडा", "🇮🇳", "marathi_vyanjan", "#FF5C8D"),
        LearningItem("mv_9", "ट - टमटम", "ट", "ट - टमटम (Cart)", "Cart", "टमटम", "गाडी", "🛺", "marathi_vyanjan", "#FF6B6B"),
        LearningItem("mv_10", "ड - डमरू", "ड", "ड - डमरू (Drum)", "Drum", "डमरू", "डमडू", "🪘", "marathi_vyanjan", "#4D96FF"),
        LearningItem("mv_11", "त - तरबूज", "त", "त - तरबूज (Watermelon)", "Watermelon", "तरबूज", "कलिंगड", "🍉", "marathi_vyanjan", "#6BCB77"),
        LearningItem("mv_12", "न - नळ", "न", "न - नळ (Tap)", "Tap", "नल", "नळ", "🚰", "marathi_vyanjan", "#FFD93D"),
        LearningItem("mv_13", "प - पतंग", "प", "प - पतंग (Kite)", "Kite", "पतंग", "पतंग", "🪁", "marathi_vyanjan", "#9370DB"),
        LearningItem("mv_14", "फ - फणस", "फ", "फ - फणस (Jackfruit)", "Jackfruit", "फणस", "फणस", "🍈", "marathi_vyanjan", "#FF8400"),
        LearningItem("mv_15", "ब - बदक", "ब", "ब - बदक (Duck)", "Duck", "बत्तख", "बदक", "🦆", "marathi_vyanjan", "#00C49F"),
        LearningItem("mv_16", "म - मगर", "म", "म - मगर (Crocodile)", "Crocodile", "मगर", "मगर", "🐊", "marathi_vyanjan", "#FF5C8D"),
        LearningItem("mv_17", "य - यज्ञ", "य", "य - यज्ञ (Fire Ritual)", "Fire Ritual", "यज्ञ", "यज्ञ", "🔥", "marathi_vyanjan", "#FF6B6B"),
        LearningItem("mv_18", "र - रथ", "र", "र - रथ (Chariot)", "Chariot", "रथ", "रथ", "🛞", "marathi_vyanjan", "#4D96FF"),
        LearningItem("mv_19", "ल - लसूण", "ल", "ल - लसूण (Garlic)", "Garlic", "लहसुन", "लसूण", "🧄", "marathi_vyanjan", "#6BCB77"),
        LearningItem("mv_20", "व - वजन", "व", "व - वजन (Weight)", "Weight", "वजन", "वजन", "⚖️", "marathi_vyanjan", "#FFD93D"),
        LearningItem("mv_21", "श - शहामृग", "श", "श - शहामृग (Ostrich)", "Ostrich", "शर्ममृग", "शहामृग", "🐦", "marathi_vyanjan", "#9370DB"),
        LearningItem("mv_22", "स - ससा", "स", "स - ससा (Rabbit)", "Rabbit", "खरगोश", "ससा", "🐰", "marathi_vyanjan", "#FF8400"),
        LearningItem("mv_23", "ह - हत्ती", "ह", "ह - हत्ती (Elephant)", "Elephant", "हाथी", "हत्ती", "🐘", "marathi_vyanjan", "#00C49F"),
        LearningItem("mv_24", "ळ - बाळ", "ळ", "ळ - बाळ (Baby)", "Baby", "बच्चा", "बाळ", "👶", "marathi_vyanjan", "#FF5C8D")
    )

    val marathiBarakhadi = listOf(
        LearningItem("mb_1", "क - Ka", "क", "क - Ka", "Ka", "क", "क", "🔤", "marathi_barakhadi", "#FF6B6B"),
        LearningItem("mb_2", "का - Kaa", "का", "का - Kaa", "Kaa", "का", "का", "🔤", "marathi_barakhadi", "#4D96FF"),
        LearningItem("mb_3", "कि - Ki", "कि", "कि - Ki", "Ki", "कि", "कि", "🔤", "marathi_barakhadi", "#6BCB77"),
        LearningItem("mb_4", "की - Kee", "की", "की - Kee", "Kee", "की", "की", "🔤", "marathi_barakhadi", "#FFD93D"),
        LearningItem("mb_5", "कु - Ku", "कु", "कु - Ku", "Ku", "कु", "कु", "🔤", "marathi_barakhadi", "#9370DB"),
        LearningItem("mb_6", "कू - Koo", "कू", "कू - Koo", "Koo", "कू", "कू", "🔤", "marathi_barakhadi", "#FF8400"),
        LearningItem("mb_7", "के - Ke", "के", "के - Ke", "Ke", "के", "के", "🔤", "marathi_barakhadi", "#00C49F"),
        LearningItem("mb_8", "कै - Kai", "कै", "कै - Kai", "Kai", "कै", "कै", "🔤", "marathi_barakhadi", "#FF5C8D"),
        LearningItem("mb_9", "को - Ko", "को", "को - Ko", "Ko", "को", "को", "🔤", "marathi_barakhadi", "#FF6B6B"),
        LearningItem("mb_10", "कौ - Kau", "कौ", "कौ - Kau", "Kau", "कौ", "कौ", "🔤", "marathi_barakhadi", "#4D96FF"),
        LearningItem("mb_11", "कं - Kam", "कं", "कं - Kam", "Kam", "कं", "कं", "🔤", "marathi_barakhadi", "#6BCB77"),
        LearningItem("mb_12", "कः - Kaha", "कः", "कः - Kaha", "Kaha", "कः", "कः", "🔤", "marathi_barakhadi", "#FFD93D")
    )

    val numbers = listOf(
        LearningItem("1", "1 - One", "१ - एक", "१ - एक", "1 Finger", "1 उंगली", "1 बोट", "☝️", "numbers", "#FF6B6B"),
        LearningItem("2", "2 - Two", "२ - दो", "२ - दोन", "2 Eyes", "2 आँखें", "2 डोळे", "👀", "numbers", "#4D96FF"),
        LearningItem("3", "3 - Three", "३ - तीन", "३ - तीन", "3 Stars", "3 तारे", "3 तारे", "⭐⭐⭐", "numbers", "#6BCB77"),
        LearningItem("4", "4 - Four", "४ - चार", "४ - चार", "4 Wheels", "4 पहिये", "4 चाके", "🚗", "numbers", "#FFD93D"),
        LearningItem("5", "5 - Five", "५ - पांच", "५ - पाच", "5 Fingers", "5 उंगलियां", "5 बोटे", "✋", "numbers", "#9370DB"),
        LearningItem("6", "6 - Six", "६ - छः", "६ - सहा", "6 Flowers", "6 फूल", "6 फुले", "🌺", "numbers", "#FF8400"),
        LearningItem("7", "7 - Seven", "७ - सात", "७ - सात", "7 Rainbow Colors", "7 रंग", "7 रंग", "🌈", "numbers", "#00C49F"),
        LearningItem("8", "8 - Eight", "८ - आठ", "८ - आठ", "8 Legs", "8 पैर", "8 पाय", "🕷️", "numbers", "#FF5C8D"),
        LearningItem("9", "9 - Nine", "९ - नौ", "९ - नऊ", "9 Balloons", "9 गुब्बारे", "9 फुगे", "🎈", "numbers", "#FF6B6B"),
        LearningItem("10", "10 - Ten", "१० - दस", "१० - दहा", "10 Coconuts", "10 नारियल", "10 नारळ", "🥥", "numbers", "#4D96FF"),
        LearningItem("11", "11 - Eleven", "११ - ग्यारह", "११ - अकरा", "11 Birds", "11 पक्षी", "11 पक्षी", "🐦", "numbers", "#6BCB77"),
        LearningItem("12", "12 - Twelve", "१२ - बारह", "१२ - बारा", "12 Bananas", "12 केले", "12 केळी", "🍌", "numbers", "#FFD93D"),
        LearningItem("13", "13 - Thirteen", "१३ - तेरह", "१३ - तेरा", "13 Candies", "13 टॉफी", "13 चॉकलेट", "🍬", "numbers", "#9370DB"),
        LearningItem("14", "14 - Fourteen", "१४ - चौदह", "१४ - चौदा", "14 Books", "14 किताबें", "14 पुस्तके", "📚", "numbers", "#FF8400"),
        LearningItem("15", "15 - Fifteen", "१५ - पंद्रह", "१५ - पंधरा", "15 Apples", "15 सेब", "15 सफरचंद", "🍎", "numbers", "#00C49F"),
        LearningItem("16", "16 - Sixteen", "१६ - सोलह", "१६ - सोळा", "16 Pens", "16 पेन", "16 पेन", "🖊️", "numbers", "#FF5C8D"),
        LearningItem("17", "17 - Seventeen", "१७ - सत्रह", "१७ - सतरा", "17 Balls", "17 गेंद", "17 चेंडू", "⚽", "numbers", "#FF6B6B"),
        LearningItem("18", "18 - Eighteen", "१८ - अठारह", "१८ - अठरा", "18 Toys", "18 खिलौने", "18 खेळणी", "🧸", "numbers", "#4D96FF"),
        LearningItem("19", "19 - Nineteen", "१९ - उन्नीस", "१९ - ओणिसा", "19 Stars", "19 तारे", "19 तारे", "⭐", "numbers", "#6BCB77"),
        LearningItem("20", "20 - Twenty", "२० - बीस", "२० - वीस", "20 Blocks", "20 ब्लॉक", "20 ठोकळे", "🟩", "numbers", "#FFD93D")
    )

    val shapes = listOf(
        LearningItem("circle", "Circle", "वृत्त (गोला)", "वर्तुळ", "Round shape", "गोल आकार", "गोल आकार", "⭕", "shapes", "#FF6B6B"),
        LearningItem("square", "Square", "वर्ग (चौकोर)", "चौकोन", "4 Equal sides", "4 बराबर भुजाएं", "4 समान बाजू", "⬛", "shapes", "#4D96FF"),
        LearningItem("triangle", "Triangle", "त्रिकोण", "त्रिकोण", "3 Corners", "3 कोने", "3 कोपरे", "🔺", "shapes", "#6BCB77"),
        LearningItem("rectangle", "Rectangle", "आयताकार", "आययत", "Opposite sides equal", "आमने-सामने की भुजाएं बराबर", "समोरासमोरील बाजू समान", "🟩", "shapes", "#FFD93D"),
        LearningItem("star", "Star", "तारा", "तारा", "Twinkle star", "चमकता तारा", "चमचमणारा तारा", "⭐", "shapes", "#9370DB"),
        LearningItem("heart", "Heart", "दिल", "हृदय", "Symbol of love", "प्यार का प्रतीक", "प्रेमाचे प्रतीक", "❤️", "shapes", "#FF5C8D"),
        LearningItem("oval", "Oval", "अंडाकार", "अंडाकृती", "Egg shape", "अंडे जैसा आकार", "अंड्यासारखा आकार", "🥚", "shapes", "#FF8400"),
        LearningItem("diamond", "Diamond", "हीरा", "हिरा", "Rhombus shape", "हीरे जैसा आकार", "हिऱ्यासारखा आकार", "💎", "shapes", "#00C49F")
    )

    val colors = listOf(
        LearningItem("red", "Red", "लाल", "लाल", "Apple color", "सेब का रंग", "सफरचंदाचा रंग", "🔴", "colors", "#FF4136"),
        LearningItem("blue", "Blue", "नीला", "निळा", "Sky color", "आसमान का रंग", "आकाशाचा रंग", "🔵", "colors", "#0074D9"),
        LearningItem("green", "Green", "हरा", "हिरवा", "Leaf color", "पत्ती का रंग", "पानाचा रंग", "🟢", "colors", "#2ECC40"),
        LearningItem("yellow", "Yellow", "पीला", "पिवळा", "Sun color", "सूरज का रंग", "सूर्याचा रंग", "🟡", "colors", "#FFDC00"),
        LearningItem("orange", "Orange", "नारंगी", "नारिंगी", "Orange fruit color", "संतरे का रंग", "संत्र्याचा रंग", "🟠", "colors", "#FF851B"),
        LearningItem("purple", "Purple", "बैंगनी", "जांभळा", "Brinjal color", "बैंगन का रंग", "वांग्याचा रंग", "🟣", "colors", "#B10DC9"),
        LearningItem("pink", "Pink", "गुलाबी", "गुलाबी", "Rose color", "गुलाब का रंग", "गुलाबाचा रंग", "🌸", "colors", "#FF69B4"),
        LearningItem("brown", "Brown", "भूरा", "तपकिरी", "Chocolate color", "चॉकलेट का रंग", "चॉकलेटचा रंग", "🟤", "colors", "#8B4513"),
        LearningItem("black", "Black", "काला", "काळा", "Night color", "रात का रंग", "रात्रीचा रंग", "⚫", "colors", "#111111"),
        LearningItem("white", "White", "सफेद", "पांढरा", "Milk color", "दूध का रंग", "दुधाचा रंग", "⚪", "colors", "#DDDDDD")
    )

    val daysOfWeek = listOf(
        LearningItem("mon", "Monday", "सोमवार", "सोमवार", "First weekday", "सोमवार", "सोमवार", "📅", "days", "#FF6B6B"),
        LearningItem("tue", "Tuesday", "मंगलवार", "मंगळवार", "Tuesday", "मंगलवार", "मंगळवार", "📅", "days", "#4D96FF"),
        LearningItem("wed", "Wednesday", "बुधवार", "बुधवार", "Wednesday", "बुधवार", "बुधवार", "📅", "days", "#6BCB77"),
        LearningItem("thu", "Thursday", "गुरुवार", "गुरुवार", "Thursday", "गुरुवार", "गुरुवार", "📅", "days", "#FFD93D"),
        LearningItem("fri", "Friday", "शुक्रवार", "शुक्रवार", "Friday", "शुक्रवार", "शुक्रवार", "📅", "days", "#9370DB"),
        LearningItem("sat", "Saturday", "शनिवार", "शनिवार", "Saturday", "शनिवार", "शनिवार", "🎈", "days", "#FF8400"),
        LearningItem("sun", "Sunday", "रविवार", "रविवार", "Sunday (Holiday)", "रविवार", "रविवार", "☀️", "days", "#00C49F")
    )

    val englishMonths = listOf(
        LearningItem("m_jan", "January", "जनवरी", "जानेवारी", "1st Month", "जनवरी", "जानेवारी", "❄️", "english_months", "#FF6B6B"),
        LearningItem("m_feb", "February", "फरवरी", "फेब्रुवारी", "2nd Month", "फरवरी", "फेब्रुवारी", "🌷", "english_months", "#4D96FF"),
        LearningItem("m_mar", "March", "मार्च", "मार्च", "3rd Month", "मार्च", "मार्च", "🌱", "english_months", "#6BCB77"),
        LearningItem("m_apr", "April", "अप्रैल", "एप्रिल", "4th Month", "अप्रैल", "एप्रिल", "🌦️", "english_months", "#FFD93D"),
        LearningItem("m_may", "May", "मई", "मे", "5th Month", "मई", "मे", "☀️", "english_months", "#9370DB"),
        LearningItem("m_jun", "June", "जून", "जून", "6th Month", "जून", "जून", "🌧️", "english_months", "#FF8400"),
        LearningItem("m_jul", "July", "जुलाई", "जुलै", "7th Month", "जुलाई", "जुलै", "☔", "english_months", "#00C49F"),
        LearningItem("m_aug", "August", "अगस्त", "ऑगस्ट", "8th Month", "अगस्त", "ऑगस्ट", "🇮🇳", "english_months", "#FF5C8D"),
        LearningItem("m_sep", "September", "सितंबर", "सप्टेंबर", "9th Month", "सितंबर", "सप्टेंबर", "🍂", "english_months", "#FF6B6B"),
        LearningItem("m_oct", "October", "अक्टूबर", "ऑक्टोबर", "10th Month", "अक्टूबर", "ऑक्टोबर", "🎃", "english_months", "#4D96FF"),
        LearningItem("m_nov", "November", "नवंबर", "नोव्हेंबर", "11th Month", "नवंबर", "नोव्हेंबर", "🌟", "english_months", "#6BCB77"),
        LearningItem("m_dec", "December", "दिसंबर", "डिसेंबर", "12th Month", "दिसंबर", "डिसेंबर", "🎄", "english_months", "#FFD93D")
    )

    val indianMonths = listOf(
        LearningItem("im_1", "Chaitra", "चैत्र", "चैत्र", "1st Hindu Month", "चैत्र (पहला महीना)", "चैत्र (पहिला महिना)", "🪔", "indian_months", "#FF8400"),
        LearningItem("im_2", "Vaishakha", "वैशाख", "वैशाख", "2nd Hindu Month", "वैशाख", "वैशाख", "🌾", "indian_months", "#FF6B6B"),
        LearningItem("im_3", "Jyeshtha", "ज्येष्ठ", "ज्येष्ठ", "3rd Hindu Month", "ज्येष्ठ", "ज्येष्ठ", "☀️", "indian_months", "#4D96FF"),
        LearningItem("im_4", "Ashadha", "आषाढ", "आषाढ", "4th Hindu Month (Rain)", "आषाढ (बरसात)", "आषाढ", "🌧️", "indian_months", "#6BCB77"),
        LearningItem("im_5", "Shravana", "श्रावण", "श्रावण", "5th Hindu Month (Festivals)", "श्रावण (त्यौहार)", "श्रावण (सण)", "🪅", "indian_months", "#FFD93D"),
        LearningItem("im_6", "Bhadrapada", "भाद्रपद", "भाद्रपद", "6th Hindu Month (Ganesh Utsav)", "भाद्रपद (गणेशोत्सव)", "भाद्रपद", "🐘", "indian_months", "#9370DB"),
        LearningItem("im_7", "Ashwin", "आश्विन", "आश्विन", "7th Hindu Month (Navratri/Diwali)", "आश्विन (दिवाली)", "आश्विन", "🪔", "indian_months", "#FF5C8D"),
        LearningItem("im_8", "Kartika", "कार्तिक", "कार्तिक", "8th Hindu Month", "कार्तिक", "कार्तिक", "🕯️", "indian_months", "#00C49F"),
        LearningItem("im_9", "Margashirsha", "मार्गशीर्ष", "मार्गशीर्ष", "9th Hindu Month", "मार्गशीर्ष", "मार्गशीर्ष", "🌺", "indian_months", "#FF8400"),
        LearningItem("im_10", "Pausha", "पौष", "पौष", "10th Hindu Month", "पौष", "पौष", "❄️", "indian_months", "#4D96FF"),
        LearningItem("im_11", "Magha", "माघ", "माघ", "11th Hindu Month", "माघ", "माघ", "🌞", "indian_months", "#6BCB77"),
        LearningItem("im_12", "Phalguna", "फाल्गुन", "फाल्गुन", "12th Hindu Month (Holi)", "फाल्गुन (होली)", "फाल्गुन (होळी)", "🎨", "indian_months", "#FFD93D")
    )

    val fruitsVeg = listOf(
        LearningItem("apple", "Apple", "सेब", "सफरचंद", "Healthy fruit", "स्वास्थ्यवर्धक फल", "आरोह्यदायी फळ", "🍎", "fruits_veg", "#FF6B6B"),
        LearningItem("banana", "Banana", "केला", "केळी", "Energy fruit", "ऊर्जा देने वाला फल", "ऊर्जा देणारे फळ", "🍌", "fruits_veg", "#FFD93D"),
        LearningItem("mango", "Mango", "आम", "आंबा", "King of fruits", "फलों का राजा", "फळांचा राजा", "🥭", "fruits_veg", "#FF8400"),
        LearningItem("grapes", "Grapes", "अंगूर", "द्रेक्षा", "Sweet juicy", "रसीले अंगूर", "गोड द्रेक्ष", "🍇", "fruits_veg", "#6BCB77"),
        LearningItem("orange_fruit", "Orange", "संतरा", "संत्रा", "Vitamin C", "विटामिन सी", "व्हिटॅमिन सी", "🍊", "fruits_veg", "#FF9F43"),
        LearningItem("potato", "Potato", "आलू", "बटाटा", "King of vegetables", "सब्जियों का राजा", "भाजीपाल्याचा राजा", "🥔", "fruits_veg", "#C86D51"),
        LearningItem("tomato", "Tomato", "टमाटर", "टोमॅटो", "Red juicy veggie", "लाल टमाटर", "लाल टोमॅटो", "🍅", "fruits_veg", "#FF4D4D"),
        LearningItem("onion", "Onion", "प्याज", "कांदा", "Onion", "प्याज", "कांदा", "🧅", "fruits_veg", "#A29BFE"),
        LearningItem("carrot", "Carrot", "गाजर", "गाजर", "Good for eyes", "आंखों के लिए अच्छा", "डोळ्यांसाठी चांगले", "🥕", "fruits_veg", "#E17055"),
        LearningItem("cabbage", "Cabbage", "पत्तागोभी", "कोबी", "Green leafy", "पत्तागोभी", "हिरवी कोबी", "🥬", "fruits_veg", "#00B894")
    )

    val animalsBirds = listOf(
        LearningItem("lion", "Lion", "शेर", "सिंह", "King of jungle", "जंगल का राजा", "जंगलाचा राजा", "🦁", "animals_birds", "#FF8400"),
        LearningItem("tiger", "Tiger", "बाघ", "वाघ", "National animal", "राष्ट्रीय पशु", "राष्ट्रीय प्राणी", "🐅", "animals_birds", "#FF6B6B"),
        LearningItem("elephant", "Elephant", "हाथी", "हत्ती", "Big animal", "बड़ा जानवर", "मोठा प्राणी", "🐘", "animals_birds", "#9370DB"),
        LearningItem("monkey", "Monkey", "बंदर", "माकड", "Jumping animal", "कूदने वाला बंदर", "उड्या मारणारा माकड", "🐒", "animals_birds", "#6BCB77"),
        LearningItem("dog", "Dog", "कुत्ता", "कुत्रा", "Faithful pet", "वफादार पालतू", "विश्वासू पाळीव प्राणी", "🐶", "animals_birds", "#4D96FF"),
        LearningItem("parrot", "Parrot", "तोता", "पोपट", "Green talker", "हरा तोता", "हिरवा पोपट", "🦜", "animals_birds", "#00C49F"),
        LearningItem("peacock", "Peacock", "मोर", "मोर", "National bird", "राष्ट्रीय पक्षी", "राष्ट्रीय पक्षी", "🦚", "animals_birds", "#0074D9"),
        LearningItem("sparrow", "Sparrow", "गौरैया", "चिमणी", "Small bird", "छोटी गौरैया", "छोट्या चिमण्या", "🐦", "animals_birds", "#FFD93D"),
        LearningItem("pigeon", "Pigeon", "कबूतर", "कबुतर", "Peace bird", "शांति का प्रतीक", "शांततेचा पक्षी", "🕊️", "animals_birds", "#B2BEC3"),
        LearningItem("duck", "Duck", "बत्तख", "बदक", "Water bird", "पानी की बत्तख", "पाण्यातील बदक", "🦆", "animals_birds", "#0984E3")
    )

    val vehicles = listOf(
        LearningItem("car", "Car", "कार", "कार", "Fast four wheeler", "चार पहिया गाड़ी", "चार चाकी गाडी", "🚗", "vehicles", "#FF6B6B"),
        LearningItem("bus", "Bus", "बस", "बस", "Public transport", "बड़ी बस", "प्रवाशांची बस", "🚌", "vehicles", "#4D96FF"),
        LearningItem("train", "Train", "रेलगाड़ी", "आगाडी", "Tracks runner", "छुक-छुक रेलगाड़ी", "आगाडी छुक छुक", "🚂", "vehicles", "#6BCB77"),
        LearningItem("airplane", "Airplane", "हवाई जहाज", "विमान", "Fly in sky", "आसमान में उड़ने वाला", "आकाशात उडणारे विमान", "✈️", "vehicles", "#FFD93D"),
        LearningItem("bicycle", "Bicycle", "साइकिल", "सायकल", "Pedal ride", "पैडल वाली साइकिल", "पॅडल सायकल", "🚲", "vehicles", "#9370DB"),
        LearningItem("motorcycle", "Motorcycle", "मोटरसाइकिल", "मोटारसायकल", "Two wheeler", "बाइक", "दुचाकी", "🏍️", "vehicles", "#FF8400"),
        LearningItem("helicopter", "Helicopter", "हेलीकॉप्टर", "हेलिकॉप्टर", "Propeller flyer", "हेलीकॉप्टर", "हेलिकॉप्टर", "🚁", "vehicles", "#00C49F"),
        LearningItem("boat", "Boat", "नाव", "नाव", "Water boat", "पानी की नाव", "पाण्यातील नाव", "⛵", "vehicles", "#FF5C8D"),
        LearningItem("ambulance", "Ambulance", "एम्बुलेंस", "रुग्णवाहिका", "Emergency vehicle", "आपातकालीन वाहन", "रुग्णवाहिका", "🚑", "vehicles", "#FF4D4D"),
        LearningItem("tractor", "Tractor", "ट्रैक्टर", "ट्रॅक्टर", "Farm vehicle", "किसान का ट्रैक्टर", "शेतकऱ्याचा ट्रॅक्टर", "🚜", "vehicles", "#00B894")
    )

    fun getItemsForCategory(categoryId: String): List<LearningItem> {
        return when (categoryId) {
            "alphabets_en" -> englishAlphabets
            "hindi_swar" -> hindiSwar
            "hindi_vyanjan" -> hindiVyanjan
            "hindi_barakhadi" -> hindiBarakhadi
            "marathi_swar" -> marathiSwar
            "marathi_vyanjan" -> marathiVyanjan
            "marathi_barakhadi" -> marathiBarakhadi
            "numbers" -> numbers
            "shapes" -> shapes
            "colors" -> colors
            "days" -> daysOfWeek
            "english_months" -> englishMonths
            "indian_months" -> indianMonths
            "fruits_veg" -> fruitsVeg
            "animals_birds" -> animalsBirds
            "vehicles" -> vehicles
            else -> emptyList()
        }
    }
}
