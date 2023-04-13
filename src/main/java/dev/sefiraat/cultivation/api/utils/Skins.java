package dev.sefiraat.cultivation.api.utils;

import io.github.bakedlibs.dough.skins.PlayerHead;
import io.github.bakedlibs.dough.skins.PlayerSkin;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * This enum contains hashes for the skulls used in the addon with Methods for generating ItemStacks/Skins
 */
public enum Skins {
    // region Seeds

    // https://minesk.in/420812538
    SEED_RED("660e8f971fcc83cf57a3e15b458317119e9f623d441bbf197e68125c80a23f30"),
    // https://minesk.in/1653180579
    SEED_ORANGE("db28b2cb42082d1cf1b31a26f9d3855c782d055482a43f675b42435152a95543"),
    // https://minesk.in/1452126246
    SEED_YELLOW("81170da7341f323f8e4a3d0f8ca379f9af31511f346699f4bf0d09db95f63c6f"),
    // https://minesk.in/345231516
    SEED_GREEN("95b92a13f01baece56654e817833f9829bc025ad733609c0bdd0d3a359c9d943"),
    // https://minesk.in/127668043
    SEED_BLUE("9fd6f27013701cd46bf32066ef2ecf90f1099be89f2e0bd9cc145479970c24b6"),
    // https://minesk.in/982733904
    SEED_CYAN("22be7169884ad820acaed7a717679cd0d91dcd3d6c1db81e6ac28a2bcd3534a0"),
    // https://minesk.in/2017750386
    SEED_PURPLE("981f7002b063a4b70360efa779eb58b0b3c9c8d59d57bc33f772eaf748e60a79"),

    // https://minesk.in/966096940
    VINEY_RED_1("4dbbfb342661c57c5c504f7c93debe3557757b034149a3ef72ce5236b56fc54c"),
    // https://minesk.in/1438648149
    VINEY_RED_2("dbd7d8b141bcad5deac3f139eebedb6acee9f9c8c3ae205eebe2c9c5f15839a6"),
    // https://minesk.in/946774698
    VINEY_RED_3("56aba8c4c42f71e1a9d929b27f137527ce6097978b0134cbc41e8da3c0d69b1a"),
    // https://minesk.in/1482065240
    VINEY_RED_4("83c8d346c45599c40ca284e7a0d549479488fabe3374458c8e7f47a20ff9f446"),
    // https://minesk.in/471953318
    VINEY_RED_5("b656ebee195ba6eea2a1ec7c732c2588c6c824ec569650b12d074d8402b624f"),

    // https://minesk.in/1495316923
    VINEY_ORANGE_1("768e05e07ff69c786e1a13809e7ced0ea659bf80b54e38ffdb498378e6f5e487"),
    // https://minesk.in/178089894
    VINEY_ORANGE_2("dc51b388a40ccaf00d40f454709085064953ae5bc42a46149ceaf41976cedc53"),
    // https://minesk.in/1074486879
    VINEY_ORANGE_3("6f25ea870a03f6ac0fc3692705bf85e1d24ff43dd3e050bf5a52d8529db9fcd8"),
    // https://minesk.in/1976056035
    VINEY_ORANGE_4("15531c663391ffb55bb257c2f53c5bc17b78d2695e516eda67971b5145c96393"),
    // https://minesk.in/519350049
    VINEY_ORANGE_5("688af28611e334a8afbe83490e1d6280a60b0ffe58c087104822d73a6b290cf0"),

    // https://minesk.in/170591458
    VINEY_YELLOW_1("73c87ede1d3fc20f6764762ba2fb274066b11c4390599c441ef7902ca5a59e40"),
    // https://minesk.in/1095069450
    VINEY_YELLOW_2("ca3e93bcac9c660f3bb647b0daa33ccd3695c6f20940ba7b30c730a9cbae9f2"),
    // https://minesk.in/503852470
    VINEY_YELLOW_3("46d229e0364533da2f685e554d2d352cb58d43daf21d63d919cc954a5f0a0f0"),
    // https://minesk.in/1011048560
    VINEY_YELLOW_4("7be60590c4784ede4148ffb058ad3948e050264931e341397f4870a0c8f850a4"),
    // https://minesk.in/356148734
    VINEY_YELLOW_5("fa95153fc73058dabee2181a3b2c10774428e5dfee6e82b324e84ea06ea8d272"),

    // https://minesk.in/834747675
    VINEY_GREEN_1("66bdd5e057eedf80b8e5a1e8243241bb91afffe1b65bf04d24647b3595969cb0"),
    // https://minesk.in/1526734309
    VINEY_GREEN_2("1da103af6aecef119fd9a551232615ff1fae725bdeb36eeb611efadd3fcf6349"),
    // https://minesk.in/858054997
    VINEY_GREEN_3("b77ca14b50c10fa1bc8d71c0d61f9e3022dfba6bdd87440d32e50bd43136a99"),
    // https://minesk.in/1824080260
    VINEY_GREEN_4("3589691376785c10327433e7810beef7912005c7517fd5d8977ed94078f56a14"),
    // https://minesk.in/297990353
    VINEY_GREEN_5("dff0e450b1bd59c2dc1e66d08202e8fa5d4839fd69e60491880a54dee0865ff8"),

    // https://minesk.in/1067572747
    VINEY_BLUE_1("da7799cbc025547f053928c0635456b06b4a66d4e088ba24216828d5d428487a"),
    // https://minesk.in/25450851
    VINEY_BLUE_2("5ee6ea1dbe7d9ebcee35cb9757faa9ef83d03290a794e357b31b4edec04cb3ce"),
    // https://minesk.in/1259553091
    VINEY_BLUE_3("6807c9a552dd86ac9166667b203d938b362e5a1a167676093822ef1197af095"),
    // https://minesk.in/1465152506
    VINEY_BLUE_4("5bcbc44bd5480eee1fa908cac20d52510fc3b04e7aad5455a235929f5e03a23e"),
    // https://minesk.in/1446710099
    VINEY_BLUE_5("b1c7c32ad07715a5e610dfb7d292b330f70cfc00551aca5cbf2a374c2aedcc75"),

    // https://minesk.in/504009261
    VINEY_CYAN_1("c2c2148da3ee74b17f9938937aed04de8d862ebff52e91b20421280ac27e0caf"),
    // https://minesk.in/1387395783
    VINEY_CYAN_2("476a7207882265e290f420704b8e5f9409ed3b0e03c0ea3173cb212d78a9d247"),
    // https://minesk.in/192061692
    VINEY_CYAN_3("8c04d5270cd260da455363cc0eeec3901bec8ef9f1d1f25200c681cc2e796d56"),
    // https://minesk.in/53256019
    VINEY_CYAN_4("521167044ffdc9127c0399a4daf74d0a59889804425042369258a9bcbd80dba7"),
    // https://minesk.in/596505149
    VINEY_CYAN_5("d71c02a3972ff608ecedb0dc92722d177ac89f25ba6f632ca38eda01fc4ea03c"),

    // https://minesk.in/1167642457
    VINEY_PURPLE_1("dd0d11751f3d31e6518fc586e1824fb57f8ee17ea45c0bff123a81d77089be80"),
    // https://minesk.in/673916336
    VINEY_PURPLE_2("8bcdd04b32b650ba86b6677e40432272a658dc198fbf26d75d6e72aba9475a09"),
    // https://minesk.in/1845663711
    VINEY_PURPLE_3("77430fece1a8c15ffa95fea4c3d61da7fbb7ff1006969183fa27f2c844eace16"),
    // https://minesk.in/247758607
    VINEY_PURPLE_4("6892e85b05a02e28d85cdec359547919d31fb71b9f70af89bb0ef0c710e9dddb"),
    // https://minesk.in/2112413733
    VINEY_PURPLE_5("93ee8ff4259fb10ea229399c0bc4b12e3c393d3dc94a0c4610a6bc2ec11940f9"),

    // https://mineskin.org/184506748
    SPAWNING_RED_1("f994c09cea8dbeaad2e6ef99ef111f4e9d95bb3becf9d7c5b48e3cfd8d4deaf"),
    // https://mineskin.org/897984990
    SPAWNING_RED_2("8701442d9902dfb65d4f688531dfa5f78c0ed69313d9ca8e70aab1cd278c6a8b"),
    // https://mineskin.org/1689699210
    SPAWNING_RED_3("eb240077555fbe9bc5ed31740afe15dd6767e0936b75baa20edf3275dacb169e"),
    // https://mineskin.org/1230103550
    SPAWNING_RED_4("daace8113c2d1b63fb7ad79602e760014edb19c43a41efa01f64ee279818f612"),
    // https://mineskin.org/1689602026
    SPAWNING_RED_5("d58dad2e69af296791e6d717422710fd8aa3b6931040688ce9bdf4bdc37584ff"),

    // https://mineskin.org/951866684
    SPAWNING_ORANGE_1("9eab4c027d92ffc468212fd6017a6b27edad19d5438b96b4c41cf1ccef3f80da"),
    // https://mineskin.org/1567831122
    SPAWNING_ORANGE_2("b2c5b3e4c21f87aeb216d97de24412190d3727a31412696df61f2ae4d2b7b385"),
    // https://mineskin.org/1728038424
    SPAWNING_ORANGE_3("cf80c09c0dbb0b3aba3503a35141daf12ca62beec292ed6c1a7781ad844a7852"),
    // https://mineskin.org/1901134455
    SPAWNING_ORANGE_4("9bb7987737c1bee0b684d1322575191e27f7f2010b7ea510f6fcbcc04a8cf108"),
    // https://mineskin.org/2117905242
    SPAWNING_ORANGE_5("24f21f1e1b7dbe3a049dd32302253efc380c758107b902834aab13f21e4c15d9"),

    // https://mineskin.org/991443425
    SPAWNING_YELLOW_1("7b90aaf63525a4511ac6628b156dc032e6258f00fa41f20445141513c7567da7"),
    // https://mineskin.org/892097746
    SPAWNING_YELLOW_2("75af891c89911b400d7857cd054a31c928448164e278a76a7fcbbf9e9081799"),
    // https://mineskin.org/909732052
    SPAWNING_YELLOW_3("d3bada2acd3d2a794ac91357284ab5361d587206fbe6975b146e2e5773afcaa3"),
    // https://mineskin.org/349370688
    SPAWNING_YELLOW_4("a6c078546d41c0b6bde241f04534cf5f38fbca65b362174de216347efbd1579a"),
    // https://mineskin.org/777671745
    SPAWNING_YELLOW_5("c52e2742a5c89e6367ac58a6980de1734187defff4970488ce6cd0bf7c48d9f8"),

    // https://mineskin.org/1779702002
    SPAWNING_GREEN_1("50fc1f8c1c1257a81372828ca9a2a41cf9e3290f3c02285caf352644da98e76a"),
    // https://mineskin.org/1678741506
    SPAWNING_GREEN_2("e23fc39e558c88e59f0cf1b9d1a67fb8e06f5cd9f73d396f8e4d7033bf145caa"),
    // https://mineskin.org/1892072174
    SPAWNING_GREEN_3("1c8237ed47b65e5cba683354de7e09d452849e683e874a029133f1bba2942ca1"),
    // https://mineskin.org/1892072174
    SPAWNING_GREEN_4("1c8237ed47b65e5cba683354de7e09d452849e683e874a029133f1bba2942ca1"),
    // https://mineskin.org/1152664535
    SPAWNING_GREEN_5("1ddf74a820029bea73668144ee889855e95a47f349000ba218f3b022b1f04b0c"),

    // https://mineskin.org/59106169
    SPAWNING_BLUE_1("61ed6c9fd7bd3557e827e57e782a6b184d1843925d88a528435ca1f6084d110"),
    // https://mineskin.org/1684433944
    SPAWNING_BLUE_2("a81b9551d20f7bbe058387d3b7c2ca699ae7fa1261cdea869c74553afa38f755"),
    // https://mineskin.org/1096273337
    SPAWNING_BLUE_3("8fcf42d8362c25622f1148fb5ca57d16110e72c8f74f878d61fab06d79e5bf8a"),
    // https://mineskin.org/555635752
    SPAWNING_BLUE_4("f3dc69ecd56883902ebdda24371edac0fb15aee752425a3bc743b4ad85caf4f"),
    // https://mineskin.org/1242588686
    SPAWNING_BLUE_5("111adf6dba9232d2165e92ed2425cd72992064dbae7d9c1a427ba69d9c22e840"),

    // https://mineskin.org/1441648448
    SPAWNING_CYAN_1("6cddf6534ae4dc109bd6c1934ae14ac12123df9049dc1b50daab1c1fc2bd2078"),
    // https://mineskin.org/1166708530
    SPAWNING_CYAN_2("832a009a82046fc72a9ec0e403874b20f428f6f5270b917c2e53659306c41a22"),
    // https://mineskin.org/1807252676
    SPAWNING_CYAN_3("dcfb0855cf129fbd0c9bcaca7dc95659e67dcc7b8ba9e0f7eecbc683e411026d"),
    // https://mineskin.org/1807252676
    SPAWNING_CYAN_4("dcfb0855cf129fbd0c9bcaca7dc95659e67dcc7b8ba9e0f7eecbc683e411026d"),
    // https://mineskin.org/1880592896
    SPAWNING_CYAN_5("3320662dec3f6a7bd6d38211c894a46c98a12571c6eb1f9184a78267bb3653a1"),

    // https://mineskin.org/858395485
    SPAWNING_PURPLE_1("9b3cd14cfe6f95f3a2ce1990aa24506c469e64a0234fec2c2035c9e9c7d90f8f"),
    // https://mineskin.org/1484060099
    SPAWNING_PURPLE_2("91ef5b87dfbc52aeac4116a6fcf21326bd34630b1c83010252686ce3f02958f5"),
    // https://mineskin.org/266963735
    SPAWNING_PURPLE_3("aaf7932cc17f5df87b4b52dcd31d28b64e76fa367cef49ee95f5639299fed0a0"),
    // https://mineskin.org/1735011326
    SPAWNING_PURPLE_4("efadb4a8a6d01812f4dd8cf051a25524e6fb58d2df325c002378b6644fc08de8"),
    // https://mineskin.org/1555542858
    SPAWNING_PURPLE_5("ecb30b3df481c831968732d961bdd61c66ee97b348a8a185575782077733e7ae"),

    // https://mineskin.org/846768076
    SPIKEY_RED_1("f82a7f0b5a7577fcd2860d0cb74f7375083fbb2246ad3427734cd33f43021bb5"),
    // https://mineskin.org/1883546382
    SPIKEY_RED_2("c367f99afa08136ef4416b6f956f3c321edea33a7d3c811e11c1a92f34d3107f"),
    // https://mineskin.org/1840741332
    SPIKEY_RED_3("af1cf346c5d40750a51f7abe10be0f178bde727d06d4febffe0ef24070b51762"),
    // https://mineskin.org/583935882
    SPIKEY_RED_4("fd97bd5265375cc3aac8dd917eb730ba046ef4f42c04b9b8d03f0913151ce767"),
    // https://mineskin.org/1597787193
    SPIKEY_RED_5("4503e94702fc5990eb484fe281cc780ab0f798078532bedde5e7ff6b924002f5"),

    // https://mineskin.org/1348352124
    SPIKEY_ORANGE_1("b048aeb2a6cbd9bb649cebf7624312f31ca7a17cedcb7287301035f9af982489"),
    // https://mineskin.org/2058856872
    SPIKEY_ORANGE_2("5031d15601cd8dfe5071df8019a4e500eb50c47351a3513d492732e203904a4f"),
    // https://mineskin.org/1306919695
    SPIKEY_ORANGE_3("41ddde952116367d3967e9d8b933d2511126bdc0b221725c677793295d40e91f"),
    // https://mineskin.org/5657364
    SPIKEY_ORANGE_4("bd96aafe872e1d229b7cb5d72f227f1d74669b1e73f8160251ecd7e9c23057f5"),
    // https://mineskin.org/301113045
    SPIKEY_ORANGE_5("9e6252f4472a0f9b4a226ead65f45033f4564b62a6577aa08af91568b6aaa7f2"),

    // https://mineskin.org/2048723446
    SPIKEY_YELLOW_1("77248dfff2daa59528f9954403f48ddffb5652ecca7f2d3c2288bcb1ab95bca8"),
    // https://mineskin.org/2035142300
    SPIKEY_YELLOW_2("14e7b63360b257b75f23db48225e6a9e6d3daf96c8d831411ca4f9a1a874c5cc"),
    // https://mineskin.org/1263659301
    SPIKEY_YELLOW_3("a262bc218a039b7f8d7f85ff099586ed3f1e7ce17a605fac6741833cd65e2fca"),
    // https://mineskin.org/1461039584
    SPIKEY_YELLOW_4("96ee562ec77726c38fb9c3aa56546c389759eb72d380589439d29c6681d5c57a"),
    // https://mineskin.org/2043661180
    SPIKEY_YELLOW_5("abecf8626dce10fc77c24f8c4c611ec306a93f85d663dddf020d0e16847b231a"),

    // https://mineskin.org/827052023
    SPIKEY_GREEN_1("1f2fa421512f9cc6b52b616789498ca64b24a755748a35952d9071b9877bb96b"),
    // https://mineskin.org/1647618694
    SPIKEY_GREEN_2("a13158311163d1d8634edc5bec10982ca6797a1141e13b6a1b731e9d25311ca"),
    // https://mineskin.org/1109227374
    SPIKEY_GREEN_3("50718148b7502085256a1960915fcbe492e715f7b29d2cad8f3da805bf51f788"),
    // https://mineskin.org/1218355899
    SPIKEY_GREEN_4("e9598bff05597588447307670fcb59741abcc4e47eb9f21249243acec85e623d"),
    // https://mineskin.org/1947354836
    SPIKEY_GREEN_5("11c4883237524820b7a54dc2fc10c4a2fb382ef5a5b11fa4d7c7ada61e9bcd67"),

    // https://mineskin.org/2140792884
    SPIKEY_BLUE_1("751da94f60610bd6503e0847d4873418cb1115999fcea42059b129c12b7e3004"),
    // https://mineskin.org/418244274
    SPIKEY_BLUE_2("ed143a9bc39d3ce3896c9923b838ca42a7c9e8924a47932ae6496edb9163a558"),
    // https://mineskin.org/747870816
    SPIKEY_BLUE_3("2c92976ce6ce9427225211a7dc06a023f5c4b3a83aa3fa01e5fea81f36b3baec"),
    // https://mineskin.org/1658423478
    SPIKEY_BLUE_4("96dcb6950c9180f7b48769c75929815dcc5781fea8766e2e099c39d353274884"),
    // https://mineskin.org/357918080
    SPIKEY_BLUE_5("6908223ba0eb362d3bb641d20750583d91450a8d868bd62665563ad0845a0e4b"),

    // https://mineskin.org/1678397913
    SPIKEY_CYAN_1("1fc19a17eda70cc1b889c5c78d3874aa85948909bd16f36e3a9b413812caf076"),
    // https://mineskin.org/1360902116
    SPIKEY_CYAN_2("157bdba2e35ff3c8bc9bd6acf562e7d10f56242998082b6ba28f5a2827eb15a5"),
    // https://mineskin.org/1845841611
    SPIKEY_CYAN_3("fdf619e95d6a4074829263f9713ba63072c99e03e625218bae3f06ff178cfb04"),
    // https://mineskin.org/940938710
    SPIKEY_CYAN_4("5a8a7b14c6d2f653d7460e42f87b6f27de33e182ff324100a2d1e8661d21fdc1"),
    // https://mineskin.org/1215350048
    SPIKEY_CYAN_5("c33817aeb0987b6588292809879b755d21d423ce3627918318df6a5599ef6047"),

    // https://mineskin.org/1139197080
    SPIKEY_PURPLE_1("c67739bdfeb009b0fd2e940600cf93a68958acbbc3e69e80c4890a5518dbc0d0"),
    // https://mineskin.org/1438694154
    SPIKEY_PURPLE_2("9254bf607d0830a8c33f266752bbef62eef777cfa16d75eafbdadca647da4df9"),
    // https://mineskin.org/1236738870
    SPIKEY_PURPLE_3("570a8c5d7f9c0e4a58f837b316d51b5008ef29e078a2aad5c54412c0fa55b95"),
    // https://mineskin.org/1297434347
    SPIKEY_PURPLE_4("c92caaca509041e1b4997d53f6d5c12e45203847817bcfdad0a9cba2f73bd405"),
    // https://mineskin.org/55569926
    SPIKEY_PURPLE_5("472cae47a81cb5af41a2bbe4977d3b6394c29bb9b8e625a8baa09f83a29486fe"),

    // https://mineskin.org/1283189774
    FUNGAL_RED_1("e5b482e148ea851380d74d04072ece4c0c892fd2b217350522b93db355fb561f"),
    // https://mineskin.org/1045011111
    FUNGAL_RED_2("e5ab927ea02d5f08bcdc51f5c09292e777f3ff50dac703078d9fc4d904f3f1f0"),
    // https://mineskin.org/1783862491
    FUNGAL_RED_3("5e7d330785f79365de04030208a4ab59ba78435116ffa6ad4036aa15524425dd"),
    // https://mineskin.org/943427451
    FUNGAL_RED_4("519bddfb0263abc57ab94091c09edbec0216bbd6674e6911497efe469cf01c65"),
    // https://mineskin.org/658819405
    FUNGAL_RED_5("42d66c718e4896940c385505ea3a4c49b51d4a3c038b8ca00df47fa1d79ee48a"),

    // https://mineskin.org/1180783531
    FUNGAL_ORANGE_1("aaf15f9c4daa0ad03f916abfa1ccf5fd5c31baddeb844568d6afbb4d78325071"),
    // https://mineskin.org/278333955
    FUNGAL_ORANGE_2("cccde42494c6f326181a638578e6f655773fa8e4587b8969d8917899b4d10cc5"),
    // https://mineskin.org/548592195
    FUNGAL_ORANGE_3("c9a04527d709a61d01196befbb5e52c03b67fe9c99c10abb74e1489ff2498dcd"),
    // https://mineskin.org/548592195
    FUNGAL_ORANGE_4("c9a04527d709a61d01196befbb5e52c03b67fe9c99c10abb74e1489ff2498dcd"),
    // https://mineskin.org/715555449
    FUNGAL_ORANGE_5("20337051d8ff712e34017b0e460378f471780776093f62f6e35bf6da47364d8e"),

    // https://mineskin.org/299031039
    FUNGAL_YELLOW_1("3de68c31890daf37bd7fcb91fe84cd55d151298b2a624291fd3b606135913780"),
    // https://mineskin.org/1607824377
    FUNGAL_YELLOW_2("4cfa7c6146fb68405e707dbd316b4d3dfb67f82d3c6fb81cec3ff5fbe96e905e"),
    // https://mineskin.org/941953563
    FUNGAL_YELLOW_3("2abfd7bafd90c554e874f8f8e54d20da3c358191bfda20ca091879c74975eb79"),
    // https://mineskin.org/96221545
    FUNGAL_YELLOW_4("7bd5f0f66ea609d937684de6a845d04b902978f98191534fd1f3ba9f1b71b3d8"),
    // https://mineskin.org/1203897481
    FUNGAL_YELLOW_5("3f338ebad1e7888a903ce5ab3a9822807c08d13ee63ab4591a702f70ceb98d47"),

    // https://mineskin.org/1881918250
    FUNGAL_GREEN_1("3921c1e5c379df0bb70553a8d8c3be6a3ca2c341709b27a75a4ab0a058a4c14f"),
    // https://mineskin.org/161208475
    FUNGAL_GREEN_2("a78e04368b00747fdfe8d60c26acc1305637d28e2e3f4c5d067516d19c598c18"),
    // https://mineskin.org/1607246239
    FUNGAL_GREEN_3("78027459a99b7aba466ed8dc449bda8d48832f95ec869371a40bb141345115e1"),
    // https://mineskin.org/1015406641
    FUNGAL_GREEN_4("9092959c15502549e78d4093898ee2e4ca3cd079753e561587d0c378a602011d"),
    // https://mineskin.org/1790471513
    FUNGAL_GREEN_5("4b45396c1a2eea8c0e4f8ceb76d93a4a512872f1db51cfb715571f554f737a37"),

    // https://mineskin.org/224433163
    FUNGAL_BLUE_1("57ebacb7ca1cf9b804cd01bc016321d46e1b4a69e7f153d5d42d1e0907f206ec"),
    // https://mineskin.org/1789304330
    FUNGAL_BLUE_2("473858df02aef4293b085b4b729c96ec904e8266cb17c744efa51925eb9a510e"),
    // https://mineskin.org/938021330
    FUNGAL_BLUE_3("7d64b0737c0e38e1ceffbaaa096106cda0557b74cc8f5e3c14f7073fee3a8ed"),
    // https://mineskin.org/1524730967
    FUNGAL_BLUE_4("68eb1a9f3326140e58d7bb82271e3fc8e3eb04808dc06bab5d85aec60b371dcb"),
    // https://mineskin.org/1910715016
    FUNGAL_BLUE_5("626f9f0eb480b96ab59303c8758d77e7584412b0e387838ac3b84eb5626c271"),

    // https://mineskin.org/1647832452
    FUNGAL_CYAN_1("d1846150771bb931dc1c3d67319537c905b446ccab2489936b4c63eee12fa530"),
    // https://mineskin.org/1593275010
    FUNGAL_CYAN_2("4923653c81f0be89804a4383360b098347fb5dd9ae5c9123e16713e53d13f423"),
    // https://mineskin.org/1560991918
    FUNGAL_CYAN_3("6e3ba06d7ce964a083b5c1c3dcc82256af4e08d1ce222dcd5a9d6327f773603b"),
    // https://mineskin.org/274642306
    FUNGAL_CYAN_4("fd363bca2524c2ba2a79b963877e5ed7d19b7e63e72157ebe303bf7b1c24c8c0"),
    // https://mineskin.org/1400920450
    FUNGAL_CYAN_5("a0186448ba098e3a4c832aa015bc93dd27be7c457928e7d236779c6dc264c804"),

    // https://mineskin.org/1818851028
    FUNGAL_PURPLE_1("c6808d0852aaa158d20e9b3e75b22a1a322d98d72e4bdb3f61ee63b325f7d1f5"),
    // https://mineskin.org/754417933
    FUNGAL_PURPLE_2("fc30c19f5b02fbce43550afc3094d1e79cd964e83a0e7e4759f6402eada21ef0"),
    // https://mineskin.org/2002929855
    FUNGAL_PURPLE_3("5740108f44a9250e725badd357f983e36818e934d3b77f8f459ad7d02606e8fe"),
    // https://mineskin.org/1599199672
    FUNGAL_PURPLE_4("6c899c4db1199c773f4f0c90e83e57384ae0e87f21009d97f5141fb73304ef72"),
    // https://mineskin.org/536929978
    FUNGAL_PURPLE_5("fc15c73a48d15942aa7a1861ae4fd088f0d0cab75b8dd1e9ad98b2851f5986bc"),

    // endregion

    // region Produce

    // https://minecraft-heads.com/custom-heads/plants/19662-banana-bunch
    BANANA("20aaa1425d2b99383697d57193f27d872442bcb995508f42d19de4af1f8612"),
    // https://minecraft-heads.com/custom-heads/plants/2235-lemon
    LEMON("4378b582d19ccc55b023eb82eda271bac4744fa2006cf5e190246e2b4d5d"),
    // https://minecraft-heads.com/custom-heads/plants/59223-orange
    ORANGE("91b0fb313d90ddafd4fd7c95ef0d51b2ff9cc13013f1d318b11d87aa002fbaa0"),
    // https://minecraft-heads.com/custom-heads/plants/33084-green-apple
    GREEN_APPLE("96c15fb4e9a31191f0cb4da56fe60334dd46eb3a582111b4f8f27eddb760e2c"),
    // https://minecraft-heads.com/custom-heads/plants/52706-pineapple
    PINEAPPLE("57c5e925a949e55db2c25efaad64512eb6dab74affb2e9f304c385b4f4b30ba5"),
    // https://minecraft-heads.com/custom-heads/plants/46777-mango
    MANGO("e4895aa67247c3eb406fb905d3f6d35acd660c6f14a85bcf7bfb898b82646e70"),
    // https://minecraft-heads.com/custom-heads/plants/44786-peach
    PEACH("fadbbab3881aacba577e27bbee1fbe4b9a50e19f5a87f8d49b636054fa1788fc"),
    // https://minecraft-heads.com/custom-heads/plants/39315-apricot
    APRICOT("534104bb1442b4034cf32595a087b7a51d96ce5915c182d833eefa68e1cec1ff"),
    // https://minecraft-heads.com/custom-heads/plants/39202-pear
    PEAR("c68dd595bdc68e1a8dc84d789f21791edd053ba3bbedbfec2e7daa7243aea217"),
    // https://minecraft-heads.com/custom-heads/plants/31879-cherry
    CHERRY("8b9b2383bae7b84fdc31b54179afb713a1c187b83e7a0c5e38470ae2a3e2a30f"),
    // https://minecraft-heads.com/custom-heads/plants/1938-kiwi
    KIWI("4cc18ec4649f07d5a38a583d9271fd83a6f37318758e46ea87fc2b2d1afc2d9"),
    // https://minecraft-heads.com/custom-heads/plants/39730-tropical-fruit
    LIME("95f6356c0cf82f7e497435c2227ab7ed98734ca1b0084bd770e53f39285ff7ec"),
    // https://minecraft-heads.com/custom-heads/plants/57802-chestnut
    CHESTNUT("7aea6b06c058546247e6567009440140946ea53623829721bd46b3e6a0e5cce8"),
    // https://minecraft-heads.com/custom-heads/plants/1214-hazelnut
    HAZELNUT("678784703fa59cd153fcabe3ccd9d44c469a8d63e6d438626ad9ebc70707fc3"),
    // https://minecraft-heads.com/custom-heads/plants/59603-pecan-without-shell
    PECAN("9813444497a48b3b68946961e49e13dd6b19467aeed1eb9d0e876bc878e0a734"),
    // https://minecraft-heads.com/custom-heads/plants/60981-grape
    GRAPE("e44c359f6f28c5fa6c5a09d8c57fa4174da4e8ae110e5f2cd7e93f2e76176cd5"),
    // https://minecraft-heads.com/custom-heads/plants/55177-peanut
    PEANUT("cf823e05353ae9122150bc67a5df7de628f4d4c30b36bdae3c1c18582bfca776"),
    // https://minecraft-heads.com/custom-heads/plants/4122-strawberry
    STRAWBERRY("b9708d818be97dc7e2c3bb5c35663eb36269236e9bc98286f429dfdf375aa9"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/12840-rice-sack
    RICE("cb70f2fb5ebf49f79ff3e873616863ae5d362fbbfc31aef2dfb93d6e17dbf2"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/42594-garlic
    GARLIC("ca5b1539b698c217cb3b4163a00e336131043311b83b08de02f1a66505be5b29"),
    // https://minecraft-heads.com/custom-heads/decoration/50929-pepper-bag
    PEPPERS("a3ef14c40251844c3ae39b6028db86a9098df325e50b7a475972cd1ac918e9d5"),
    // https://minecraft-heads.com/custom-heads/plants/33414-tomato
    TOMATO("72df4e674951c138e7311127561fdbd27e2150716b02bb568747f8545fb20145"),
    // https://minecraft-heads.com/custom-heads/plants/45539-bell-pepper
    BELL_PEPPER("65f7810414a2cee2bc1de12ecef7a4c89fc9b38e9d0414a90991241a5863705f"),
    // https://minecraft-heads.com/custom-heads/decoration/21582-sack-of-herbs
    HERBS("427423d5cce4a472a760ce5e862ca35f7058d587b7eab69ebec920c773e7307"),
    // https://minecraft-heads.com/custom-heads/decoration/32579-spice-container-cinnamon
    SPICE_BROWN("f80c9a68cd232d2568ca152685b6730a7b73bbc6abae69130361fcdcd3aa484d"),
    // https://minecraft-heads.com/custom-heads/decoration/32575-spice-container-ginger
    SPICE_YELLOW("e134dbb2e6d1c673b47b0f3a086160b480cb5d92a420c64c8f5c45ddb3e64015"),
    // https://minecraft-heads.com/custom-heads/decoration/32576-spice-container-dill
    SPICE_GREEN("282fd4afb3d4c81ab8863fcb9409d1b2b35d1f6684f9a2f515c4eae9f2ee3e2f"),
    // https://minecraft-heads.com/custom-heads/decoration/32571-spice-container-pink-salt
    SPICE_PINK("6d9d3005c9368ced2992eaf386acfdc958ae24845a72fd5b335a780cb3e12a31"),
    // https://minecraft-heads.com/custom-heads/plants/2241-onion
    ONION("a6ecc46dc3dc85fcd57198176ee841f1a041b15f73ecb19fde62ee4315c4a6"),
    // https://minecraft-heads.com/custom-heads/plants/17984-lettuce
    LETTUCE("2d52e883c6436ca7e764bda4b58afa53da6a649030f663953dce9fd6315f9fea"),
    // https://minecraft-heads.com/custom-heads/plants/33413-broccoli
    BROCCOLI("65106f0cc4c12dcfe7736a1ffc92772f41b66e1b7682b1f47537787720567262"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/58551-bundle-of-asparagus
    ASPARAGUS("2ba5599e26cf2252d431a950b2078a0af2e45c60edff9d4fadf62c323df5411f"),
    // https://minecraft-heads.com/custom-heads/plants/58595-turnip
    TURNIP("bfac2d1d21aeb8d7a0c289733511d903df57924ad6bd61d00567a55af649bc0d"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/58550-bundle-of-leeks
    LEEK("c144a523b05063c81f006fdbd8d9b75249aa009b4c1f46db27dbbeafc4a8578"),
    // https://minecraft-heads.com/custom-heads/plants/50806-parsnip
    PARSNIP("d0f61fe6d3c0e7f01434d38367b1a50db04f8cccbdbbda1806bf1198318dc7eb"),
    // https://minecraft-heads.com/custom-heads/plants/51475-cabbage
    CABBAGE("58e59dc722e419fe064f0c7992a7897b73cc7c5205e19d067a174bcb018e9429"),
    // https://minecraft-heads.com/custom-heads/plants/43379-radish
    RADDISH("cd56f448876ebfdaa88ca7f0137a6837f4d2ba14dd3d6615d82d617c39b39daf"),
    // https://minecraft-heads.com/custom-heads/plants/32990-aubergine
    AUBERGINE("521358c5b2e2526ae6aab91a5fb09198461a7cc4d860e8647d5e10fb6c87be67"),
    // https://minecraft-heads.com/custom-heads/plants/33211-cauliflower
    CAULIFLOWER("14a6dedd99bb9af3f1b2f338d509a926606cddfdc351e018aad1c07015ad566d"),
    // https://minecraft-heads.com/custom-heads/plants/19674-kale
    KALE("1b913d9d6e306d953461d1f7468321868a9bad4df53d1a7dc64b0797628f0"),
    // https://minecraft-heads.com/custom-heads/plants/19673-kohlrabi
    KOHLRABI("2969d3149333e1e658f5da69dc6131a87fa6817cda2ba6387d5f5f31e0ef73"),
    // https://minecraft-heads.com/custom-heads/plants/13125-avocado
    AVOCADO("6af2bf32bb8937a5aadfbf6d8dc56a21ef65f6884db67206280fa1e149f8c4b"),
    // https://minecraft-heads.com/custom-heads/plants/2179-corn
    CORN("d391dffbea2fc3f2ad78a623f49bf7e1121694112c3759feed4156fc2ba46c0"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/58921-squash
    SQUASH("36ae076649ef22f60e8511831c68fd2b6ea63c32164dab33a8aebc18ff2a54c8"),
    // https://minecraft-heads.com/custom-heads/plants/58594-rutabaga
    RUTABAGA("b3661e4bf4c3e730a3aaa1053a3fc524dc03df67bf7a20979efdb2ad1a9e4084"),

    // endregion

    // region By Products

    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/1662-peanut-butter
    PEANUT_BUTTER("8c27a09c43829afc89b362586d43c86df5d9aa4c149f8d5775cf129357575d3"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/74-jam-jar-blue
    JAM_JAR_BLUE("91708ed352e17ca89c1c9485cd1db017c4c886895ab5c7c27a9ff564af2172d"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/76-jam-jar-red
    JAM_JAR_RED("c0b8b5889ee1c6388dc6c2c5dbd70b6984aefe54319a095e64db7638097b821"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/69-jam-jar-orange
    JAM_JAR_ORANGE("6f363628123af11aa6f4a899cebd094f074555a41e6d335212ee7263ad39f6"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/24-jam-jar-yellow
    JAM_JAR_YELLOW("10192f33373b914a6e2d5a23c0daa5db5f77204471a36b6161ae556d3e663"),

    // endregion

    // region Foods

    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/31286-peanut-butter-jelly-sandwich
    PEANUT_BUTTER_JELLY_SANDWICH("3d532525b79064d4b504d8731178b5baab91866eb9ab53d0fde7f08c1cc0df8c"),
    MEATY_SANDWICH("f7b9f08ada4e8ba586a04ed2e9e25fe8b9d568a665243f9c603799a7c896736"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/448-ham-cheese-sandwich
    CHEESY_SANDWICH("baee84d19c85aff796c88abda21ec4c92c655e2d67b72e5e77b5aa5e99ed"),
    // https://minecraft-heads.com/custom-heads/food-drinks/60283-soup
    SOUP_1("cd1ed9b0c870e5f15cc3804b9489610fa6b1040c3b5a9941ba29c25145d6122"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/60577-breakfast-meal
    MEAL_BREAKFAST("d44eed8d613d7c61922fbedec6aa2cfb1655ccd51d673ab2153b7b2095666030"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/60573-meal
    MEAL_LUNCH("e62fe7132d0c15d2912d13f0b3784b5a07f8284bd38f39d38941beace3c60eb6"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/53408-lucky-lunch
    MEAL_VEGGIE("d644115dceaab6daae6bebc35a729feb471cf56564f9f866fcbc65b03c7af4ee"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/411-sushi-salmon
    SUSHI_SALMON("23bf8fca2af3592c5574b13e3bcf61e2fae829788535f0ddeaa7a2e45b6ba4"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/444-sushi-tuna
    SUSHI_TUNA("523df38c3b40b973715624b7d2c21ebbf04d1c496fea0c5413dd6a6db32"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/53403-pepper-poppers
    MEAL_RED_GREEN_BROWN("dd7a3c9529054efba4ef898967b944e95b8c04e41018b483d6c5690c9651b053"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/52709-ham-cheese-bowl
    MEAL_YELLOW_RED_BROWN("1eb74cc5d3d174d67d0b2a7a42d8869a356179f2bc220dd42d1ed61a3005bd46"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/2402-spaghetti
    SPAGHETTI("3c46bec5a25e3de6d1e651c75b5ee8c41d466b227d3fa27d1f289954c1497"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/52716-salad-radish
    MEAL_SALAD("68fe49b4386658ae3f7c6a6b6f80eada4f12b1ab84da3b205319701d228966ad"),
    // https://minecraft-heads.com/custom-heads/food-drinks/60064-bread-in-a-basket
    BANANA_BREAD("92f4517fb4e9f42c607f2133c6178848b95f88475b7e6e302f0d377304e9bad0"),
    // https://minecraft-heads.com/custom-heads/food-drinks/60273-banana-cupcake
    BANANA_CUPCAKE("46638683e552b05addaf711129e65ca1749a3766b39b2452d9a5d4253549297"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/40680-pumpkin-pie
    PIE_CRUST("4954c6f49abe51de7b7d69dc53e2d982468c75c6f01e821e83c79ee3058922e9"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/30179-bowl-of-pasta
    PASTA("6dc55f43e3d8420975189a70fea4df7791e4e100b4163d615b9c0d20b1dfb2be"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/33194-pasta
    PASTA_BAKE("8c97623aab35fdd26bee7d05574c9c3891983fb70ee21b9a4c2b04d796cf3e67"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/29899-mac-and-cheese
    MAC_AND_CHEESE("7b3bcd4445e1360623821a2879e497c3de25f899c94ffb9e5942e06b2ccaea65"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/40169-warm-apple-pie
    PIE_BROWN("f30ee237290dba133da01af5f88b87cce3b94bc40c5089e988852d478fa154a2"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/44607-blueberry-pie
    PIE_BLUE("a46f8e10065f6bf6369da1607227fa3a0ecb59ebe3463259d3f7d8b6720e1221"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/47-lime-pie
    PIE_LIME("5541819e8f7945faf7a8f7cc175dcc64d4e3977317f01274e3fdf18a55194421"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/32838-apple-lattice-pie
    PIE_RED("9fc7f28ee501cc203ff1a45a9d00c86908368ac676d15f777ea1cd5ce29cc718"),
    // https://minecraft-heads.com/custom-heads/food-drinks/59639-bowl-of-shakshuka
    SHAKSHUKA("35a40080b05235916844bfa97bb8810404fc36b20e041c03376d1926d8f9efd0"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/52718-salad-apple
    FRUIT_SALAD("7d562530fe1efff5d9bfdee268b6c5474b2ccefad0a1d3f84a9e2c61d87ff6ed"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/27483-pizza
    PIZZA_MUSHROOM("3b0db613e6c1c473e9112dc6b257cdee9c717703d3222f65a80b3bc91427ce2e"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/27489-pizza
    PIZZA_CHEESE("f1a689e7bfcf040575cba68cc36149203bfd713c3b81088739220ea5b7b7f9b9"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/27490-pizza
    PIZZA_PEPPERONI("21d9d2301c60d5cd8949da664fd5c63bd5e5713116183b66318a1fc99ab0b1e4"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/24965-pepperoni
    PEPPERONI("10edb47f91bdb5af0fdf3290c7d181163f5df72a3b1c7beda1d0692e36c158da"),
    // https://minecraft-heads.com/custom-heads/food%20&%20drinks/60305-pizza-dough
    DOUGH("8166d79de64abb4457ab87fa8f6706d55ce682e10db849ea6dd124095b12276e");

    // endregion


    // endregion

    @Nonnull
    private static final Skins[] CACHED_VALUES = values();

    @Nonnull
    private final String hash;
    @Nonnull
    private final PlayerSkin playerSkin;

    Skins(@Nonnull String hash) {
        this.hash = hash;
        this.playerSkin = PlayerSkin.fromHashCode(hash);
    }

    @Nonnull
    public String getHash() {
        return hash;
    }

    @Nonnull
    public ItemStack getPlayerHead() {
        return PlayerHead.getItemStack(playerSkin);
    }

    @Nonnull
    public PlayerSkin getPlayerSkin() {
        return playerSkin;
    }

    @Nonnull
    public static Skins[] getCachedValues() {
        return CACHED_VALUES;
    }
}
