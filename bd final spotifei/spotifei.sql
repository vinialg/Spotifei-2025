PGDMP                      }            spotifei    17.4    17.4 C    o           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            p           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            q           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            r           1262    16399    spotifei    DATABASE     n   CREATE DATABASE spotifei WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'pt-BR';
    DROP DATABASE spotifei;
                     postgres    false            �            1259    16521    historico_buscas    TABLE     �   CREATE TABLE public.historico_buscas (
    id_historico integer NOT NULL,
    id_usuario integer NOT NULL,
    id_musica integer NOT NULL,
    data_busca timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 $   DROP TABLE public.historico_buscas;
       public         heap r       postgres    false            �            1259    16520 !   historico_buscas_id_historico_seq    SEQUENCE     �   CREATE SEQUENCE public.historico_buscas_id_historico_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.historico_buscas_id_historico_seq;
       public               postgres    false    230            s           0    0 !   historico_buscas_id_historico_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.historico_buscas_id_historico_seq OWNED BY public.historico_buscas.id_historico;
          public               postgres    false    229            �            1259    16414    musica    TABLE     �   CREATE TABLE public.musica (
    id integer NOT NULL,
    musica character varying(255) NOT NULL,
    artista character varying(255) NOT NULL,
    album character varying(255),
    caminho_local text NOT NULL,
    genero character varying(100)
);
    DROP TABLE public.musica;
       public         heap r       postgres    false            �            1259    16413    musica_id_seq    SEQUENCE     �   CREATE SEQUENCE public.musica_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.musica_id_seq;
       public               postgres    false    220            t           0    0    musica_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.musica_id_seq OWNED BY public.musica.id;
          public               postgres    false    219            �            1259    16443    musica_playlist    TABLE     �   CREATE TABLE public.musica_playlist (
    id_mp integer NOT NULL,
    id_playlist integer NOT NULL,
    id_musica integer NOT NULL
);
 #   DROP TABLE public.musica_playlist;
       public         heap r       postgres    false            �            1259    16442    musica_playlist_id_mp_seq    SEQUENCE     �   CREATE SEQUENCE public.musica_playlist_id_mp_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.musica_playlist_id_mp_seq;
       public               postgres    false    224            u           0    0    musica_playlist_id_mp_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.musica_playlist_id_mp_seq OWNED BY public.musica_playlist.id_mp;
          public               postgres    false    223            �            1259    16481    musicas_curtidas    TABLE     �   CREATE TABLE public.musicas_curtidas (
    id integer NOT NULL,
    id_usuario integer NOT NULL,
    id_musica integer NOT NULL,
    data_curtida timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 $   DROP TABLE public.musicas_curtidas;
       public         heap r       postgres    false            �            1259    16480    musicas_curtidas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.musicas_curtidas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.musicas_curtidas_id_seq;
       public               postgres    false    226            v           0    0    musicas_curtidas_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.musicas_curtidas_id_seq OWNED BY public.musicas_curtidas.id;
          public               postgres    false    225            �            1259    16501    musicas_descurtidas    TABLE     �   CREATE TABLE public.musicas_descurtidas (
    id integer NOT NULL,
    id_usuario integer NOT NULL,
    id_musica integer NOT NULL,
    data_descurtida timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 '   DROP TABLE public.musicas_descurtidas;
       public         heap r       postgres    false            �            1259    16500    musicas_descurtidas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.musicas_descurtidas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.musicas_descurtidas_id_seq;
       public               postgres    false    228            w           0    0    musicas_descurtidas_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.musicas_descurtidas_id_seq OWNED BY public.musicas_descurtidas.id;
          public               postgres    false    227            �            1259    16425    playlist    TABLE     �   CREATE TABLE public.playlist (
    id_playlist integer NOT NULL,
    nome_playlist character varying(255) NOT NULL,
    id_usuario bigint NOT NULL
);
    DROP TABLE public.playlist;
       public         heap r       postgres    false            �            1259    16424    playlist_id_playlist_seq    SEQUENCE     �   CREATE SEQUENCE public.playlist_id_playlist_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.playlist_id_playlist_seq;
       public               postgres    false    222            x           0    0    playlist_id_playlist_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.playlist_id_playlist_seq OWNED BY public.playlist.id_playlist;
          public               postgres    false    221            �            1259    16401    usuario    TABLE     �   CREATE TABLE public.usuario (
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    usuario character varying(100) NOT NULL,
    senha character varying(255) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap r       postgres    false            �            1259    16400    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public               postgres    false    218            y           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public               postgres    false    217            �           2604    16524    historico_buscas id_historico    DEFAULT     �   ALTER TABLE ONLY public.historico_buscas ALTER COLUMN id_historico SET DEFAULT nextval('public.historico_buscas_id_historico_seq'::regclass);
 L   ALTER TABLE public.historico_buscas ALTER COLUMN id_historico DROP DEFAULT;
       public               postgres    false    230    229    230            �           2604    16417 	   musica id    DEFAULT     f   ALTER TABLE ONLY public.musica ALTER COLUMN id SET DEFAULT nextval('public.musica_id_seq'::regclass);
 8   ALTER TABLE public.musica ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    219    220    220            �           2604    16446    musica_playlist id_mp    DEFAULT     ~   ALTER TABLE ONLY public.musica_playlist ALTER COLUMN id_mp SET DEFAULT nextval('public.musica_playlist_id_mp_seq'::regclass);
 D   ALTER TABLE public.musica_playlist ALTER COLUMN id_mp DROP DEFAULT;
       public               postgres    false    224    223    224            �           2604    16484    musicas_curtidas id    DEFAULT     z   ALTER TABLE ONLY public.musicas_curtidas ALTER COLUMN id SET DEFAULT nextval('public.musicas_curtidas_id_seq'::regclass);
 B   ALTER TABLE public.musicas_curtidas ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    225    226    226            �           2604    16504    musicas_descurtidas id    DEFAULT     �   ALTER TABLE ONLY public.musicas_descurtidas ALTER COLUMN id SET DEFAULT nextval('public.musicas_descurtidas_id_seq'::regclass);
 E   ALTER TABLE public.musicas_descurtidas ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    228    227    228            �           2604    16428    playlist id_playlist    DEFAULT     |   ALTER TABLE ONLY public.playlist ALTER COLUMN id_playlist SET DEFAULT nextval('public.playlist_id_playlist_seq'::regclass);
 C   ALTER TABLE public.playlist ALTER COLUMN id_playlist DROP DEFAULT;
       public               postgres    false    222    221    222            �           2604    16404 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    217    218    218            l          0    16521    historico_buscas 
   TABLE DATA           [   COPY public.historico_buscas (id_historico, id_usuario, id_musica, data_busca) FROM stdin;
    public               postgres    false    230   ZS       b          0    16414    musica 
   TABLE DATA           S   COPY public.musica (id, musica, artista, album, caminho_local, genero) FROM stdin;
    public               postgres    false    220   �{       f          0    16443    musica_playlist 
   TABLE DATA           H   COPY public.musica_playlist (id_mp, id_playlist, id_musica) FROM stdin;
    public               postgres    false    224          h          0    16481    musicas_curtidas 
   TABLE DATA           S   COPY public.musicas_curtidas (id, id_usuario, id_musica, data_curtida) FROM stdin;
    public               postgres    false    226   }       j          0    16501    musicas_descurtidas 
   TABLE DATA           Y   COPY public.musicas_descurtidas (id, id_usuario, id_musica, data_descurtida) FROM stdin;
    public               postgres    false    228   �       d          0    16425    playlist 
   TABLE DATA           J   COPY public.playlist (id_playlist, nome_playlist, id_usuario) FROM stdin;
    public               postgres    false    222   �       `          0    16401    usuario 
   TABLE DATA           <   COPY public.usuario (id, email, usuario, senha) FROM stdin;
    public               postgres    false    218   ��       z           0    0 !   historico_buscas_id_historico_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.historico_buscas_id_historico_seq', 1292, true);
          public               postgres    false    229            {           0    0    musica_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.musica_id_seq', 26, true);
          public               postgres    false    219            |           0    0    musica_playlist_id_mp_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.musica_playlist_id_mp_seq', 23, true);
          public               postgres    false    223            }           0    0    musicas_curtidas_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.musicas_curtidas_id_seq', 6, true);
          public               postgres    false    225            ~           0    0    musicas_descurtidas_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.musicas_descurtidas_id_seq', 4, true);
          public               postgres    false    227                       0    0    playlist_id_playlist_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.playlist_id_playlist_seq', 8, true);
          public               postgres    false    221            �           0    0    usuario_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.usuario_id_seq', 5, true);
          public               postgres    false    217            �           2606    16527 &   historico_buscas historico_buscas_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.historico_buscas
    ADD CONSTRAINT historico_buscas_pkey PRIMARY KEY (id_historico);
 P   ALTER TABLE ONLY public.historico_buscas DROP CONSTRAINT historico_buscas_pkey;
       public                 postgres    false    230            �           2606    16423    musica musica_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.musica
    ADD CONSTRAINT musica_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.musica DROP CONSTRAINT musica_pkey;
       public                 postgres    false    220            �           2606    16448 $   musica_playlist musica_playlist_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.musica_playlist
    ADD CONSTRAINT musica_playlist_pkey PRIMARY KEY (id_mp);
 N   ALTER TABLE ONLY public.musica_playlist DROP CONSTRAINT musica_playlist_pkey;
       public                 postgres    false    224            �           2606    16487 &   musicas_curtidas musicas_curtidas_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.musicas_curtidas
    ADD CONSTRAINT musicas_curtidas_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.musicas_curtidas DROP CONSTRAINT musicas_curtidas_pkey;
       public                 postgres    false    226            �           2606    16507 ,   musicas_descurtidas musicas_descurtidas_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.musicas_descurtidas
    ADD CONSTRAINT musicas_descurtidas_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.musicas_descurtidas DROP CONSTRAINT musicas_descurtidas_pkey;
       public                 postgres    false    228            �           2606    16430    playlist playlist_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT playlist_pkey PRIMARY KEY (id_playlist);
 @   ALTER TABLE ONLY public.playlist DROP CONSTRAINT playlist_pkey;
       public                 postgres    false    222            �           2606    16509 "   musicas_descurtidas unique_dislike 
   CONSTRAINT     n   ALTER TABLE ONLY public.musicas_descurtidas
    ADD CONSTRAINT unique_dislike UNIQUE (id_usuario, id_musica);
 L   ALTER TABLE ONLY public.musicas_descurtidas DROP CONSTRAINT unique_dislike;
       public                 postgres    false    228    228            �           2606    16489    musicas_curtidas unique_like 
   CONSTRAINT     h   ALTER TABLE ONLY public.musicas_curtidas
    ADD CONSTRAINT unique_like UNIQUE (id_usuario, id_musica);
 F   ALTER TABLE ONLY public.musicas_curtidas DROP CONSTRAINT unique_like;
       public                 postgres    false    226    226            �           2606    16410    usuario usuario_email_key 
   CONSTRAINT     U   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_email_key UNIQUE (email);
 C   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_email_key;
       public                 postgres    false    218            �           2606    16408    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public                 postgres    false    218            �           2606    16412    usuario usuario_usuario_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_usuario_key UNIQUE (usuario);
 E   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_usuario_key;
       public                 postgres    false    218            �           1259    16538    idx_usuario_data    INDEX     d   CREATE INDEX idx_usuario_data ON public.historico_buscas USING btree (id_usuario, data_busca DESC);
 $   DROP INDEX public.idx_usuario_data;
       public                 postgres    false    230    230            �           2606    16459 "   playlist fk_nome_da_tabela_usuario    FK CONSTRAINT     �   ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT fk_nome_da_tabela_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id) ON UPDATE CASCADE ON DELETE CASCADE;
 L   ALTER TABLE ONLY public.playlist DROP CONSTRAINT fk_nome_da_tabela_usuario;
       public               postgres    false    218    222    4785            �           2606    16533 0   historico_buscas historico_buscas_id_musica_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.historico_buscas
    ADD CONSTRAINT historico_buscas_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musica(id);
 Z   ALTER TABLE ONLY public.historico_buscas DROP CONSTRAINT historico_buscas_id_musica_fkey;
       public               postgres    false    230    220    4789            �           2606    16528 1   historico_buscas historico_buscas_id_usuario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.historico_buscas
    ADD CONSTRAINT historico_buscas_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);
 [   ALTER TABLE ONLY public.historico_buscas DROP CONSTRAINT historico_buscas_id_usuario_fkey;
       public               postgres    false    4785    218    230            �           2606    16454 .   musica_playlist musica_playlist_id_musica_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.musica_playlist
    ADD CONSTRAINT musica_playlist_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musica(id);
 X   ALTER TABLE ONLY public.musica_playlist DROP CONSTRAINT musica_playlist_id_musica_fkey;
       public               postgres    false    4789    224    220            �           2606    16449 0   musica_playlist musica_playlist_id_playlist_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.musica_playlist
    ADD CONSTRAINT musica_playlist_id_playlist_fkey FOREIGN KEY (id_playlist) REFERENCES public.playlist(id_playlist);
 Z   ALTER TABLE ONLY public.musica_playlist DROP CONSTRAINT musica_playlist_id_playlist_fkey;
       public               postgres    false    4791    222    224            �           2606    16495 0   musicas_curtidas musicas_curtidas_id_musica_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.musicas_curtidas
    ADD CONSTRAINT musicas_curtidas_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musica(id);
 Z   ALTER TABLE ONLY public.musicas_curtidas DROP CONSTRAINT musicas_curtidas_id_musica_fkey;
       public               postgres    false    226    4789    220            �           2606    16490 1   musicas_curtidas musicas_curtidas_id_usuario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.musicas_curtidas
    ADD CONSTRAINT musicas_curtidas_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);
 [   ALTER TABLE ONLY public.musicas_curtidas DROP CONSTRAINT musicas_curtidas_id_usuario_fkey;
       public               postgres    false    226    218    4785            �           2606    16515 6   musicas_descurtidas musicas_descurtidas_id_musica_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.musicas_descurtidas
    ADD CONSTRAINT musicas_descurtidas_id_musica_fkey FOREIGN KEY (id_musica) REFERENCES public.musica(id);
 `   ALTER TABLE ONLY public.musicas_descurtidas DROP CONSTRAINT musicas_descurtidas_id_musica_fkey;
       public               postgres    false    220    228    4789            �           2606    16510 7   musicas_descurtidas musicas_descurtidas_id_usuario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.musicas_descurtidas
    ADD CONSTRAINT musicas_descurtidas_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);
 a   ALTER TABLE ONLY public.musicas_descurtidas DROP CONSTRAINT musicas_descurtidas_id_usuario_fkey;
       public               postgres    false    218    228    4785            l      x�}�[�#!�D�ۣ�	���c��Ǎ�㔲>�ڕ��@(xf�?�?�?�D���"���#���]�H�����<3�fLm���fid&�_h|r{�9M@3=@5uB�e�$:
!y�����|�r��Y?:?Yߩ��
R 5 �<���>I?y�S��q{�Et)�A�yF��;�*��$=}NyIvJ9�̨6���)}ɽ:@T�/�P��^ҼB6�jG!����!^uH��Z�x�W���%y�:�S@x�q�6t�J	J��\s�~�Wa�h��M���"�Wc�P��U<��������11KQ�+e����)$4%��W�N)%��GO�Q%&&�n��rIϨDyUO���A�+�[��b�HGl��Qk�kzm���|UO����{�Z�K=�n���|�'�C-���H7ѓ ��'҂8'o��\��H1��/�D�	�ԗz"=�L4Z�DZ�Sۻ��;�����H1��W�D�����Z?�������4���J���i�y}5O��("l�L+��L���j�L7��55O���:�L1s�3<�V|;��r�_ݓ�! �L1Y�ݓ�&���|���/�W�|Sͅ2���@/�������=�����{\J>b< ��g\"�ɑED~��"�� W�ȯ!D׬�Q�R61:��@�Q������5���F
!�5�����VH�����"}�L1ћ����V�E�2_S �P��w��M'��zF?��w�"���xͻH/�#'ͻH/b���w�V&j�"���k�Ez����]��`^�Hg ʉu�?���ޝ	{��R���Tn���"��c�1҄�ZNw�.d�E�>��/R����u��r�}"�����E���^�҅���{!C��|����=�	m0Ffh9����m|�{��:Đ��%���LM�QA���=\H��׽�镪��C� H�v�п��L�.$����� %�������gC������Ef�n�܃�G�S�Q�BFU��@���?w�u�)�s�AAD o��hא֩�i�FzcH�] p��D�%�-x�H�Dr���vǻ'D)i��)>%�.�N�D�%�+[@��;_���v'�\|#|�i���\#��|H$��V��R�F�R*]a��t�褢j$]"�H��@�0�	���L5�.�:+(��!E8~��tAt�W�@�@�s���t�@�ʁ�@����Hאa1U�����"䢁t��1[��5�H���z	���޳n�t�����3�_��R-x�@�@�[Lm�v�0��/j�v�^��@��T�޵H��t�6�A�t��*��Z$]":)�I�j�H��F���{z�\��:d�#��o�#�
CwfD�r˛�8��G�%��׍�[8���z�\"��E�-��-�K�f
wD�%��_hD�%�2S�	W��87 �p����#.�R8F�[�0��H��k�����1wD�%R3�#�6�D��3�m{k���{f�["m4�!3�-�Qt;#��N3�H���Ps��f�[��a�yF�%��E��d��ɶ��ُT_�"��6��"��3���n���)�n;Ǽ�C�D�%���E�%�H@�D�%��@"������D�%2�� ��K�?:�hDfRΈDHg��oy4C��I����q�&�.�|��ȣUNϔ�8'�G#�q|J$]"E�$�h��9�GG�t4��(�h@*Z*�y4"�z��ȢA�$��xk��Y4"���(�h�H��A�t�Ԝ���t�hV�.�t�N]Jd������Jd��|'4gA�E͐���Id���Ƞ2��g��;E>�����?d픓�3�����y< ����g@*�`D8	��v#uֆ����(���	� ���]��������F�tv�A;Z��	� *l��A#2�Ҋ��������AfA�+�?�HOʉlןQX��ڐ��6"k���gA�!�;;�����2 ��	q/�n� j��x� 0y,����Wє�K\w�Dʂ����te_庳�L�����J��`ݎƂ\�.�⺳�(�����H���a�p�"e��EnXXHMk��fmڲ����J����Pj�K�\����_�����̔��;Ȗ8���)x�r7R�=ŭ܍hS(ʙ-SNd�
�C��A@fq&�.='��̘]HCռ�j�ߪ�Z��d�7���H�
��2y�|#���Z�!2
�Y3�	�ɥ#rg���Z>ŋAvϷ���F*����m��ғ6���k-@,)]sh7�}rB�O��̡HOBEM�rWK���GO�r�gy�Z�AT��Xi���A3h!�q�BY�A���ʙ�6�߬&��C��Օt_�����J�C��.dd�E2��[�@�s�X1s��r<�j�On��@<�n)��)�p���O�{��In�v�ES��Kv�v!�[k��2�Ջ�� ���\lg���UZ�K�E��[��ł�r�b�FPR�µ{�E���",\����E %r��"�
��c��٢�䞊��TވP�-rO�R��D䞊}�2& �d�BЊ�̠�Dm� �1� 3h>�|-O�}�@��?z�S$>垌5���f*P��.Q���w���{2v!�PR��� �k-�ΔwJ�@�2�;:�h���u�Hq&Ѿ�*W*:�h����{2ZgA3x_2���̥�Ln�vK��j�k�?[��R���<�6f��A�H��)5F�o�S��.$[ 7�!�9Y�1�_�R�41|��85�1A��ڝ���Rl$�xc�j����4��%`$W|)3k!�`��kn�-k �$�(�[�(y0�E����'��B�z3߈5��ǯgcr��,��ܲ� SG�0�2�EԳ�6��bc5���q��&��EF��ͺ�L�Gs��T}w�~�������+����B&��-�A�us�ŗ�����D����;�k�ل{c@qf�.�q��8�k�'Ws����@�a9�.�������ĵűo�hF�Y�t �T�B�rp��E4��⸷�jh 9x]cFf�m�-f8fV����L�j��|�=S�"?��=S��r��L�]H�f���%c�h<�X3�\�s9 RB ���Y��Ez������g����@��%�a���$�0(�����aR8�څ�p˂����@����2� |�92���d�eH��� |��_��f�|Mn>{�q��a��27F'��jn�-kr�[߹=0xB�o�QYd�	f<1ȼY��T,f掴�U��T�����&_���f7������f7� ��
F`1nR���F�M*��M*##s�L���M8�!ˊ�\l�2���ɬf��l�ʽ:���������>�v!a�_Ʌ� N��>U�J^2u�G�J�LV���|���]ů�©$�s5Ư���W�f&�Jj�ky1=ex�Z��Q8V��d7Q�4����Ac3�ɕZ��q.������s�����%��?hl���Ac3ȨX�4
�����\����i�\����"�r�c�A�j��HΈ�Y�r�[��Lf�m�Fr&��;��H��p/ �H�\G.�K�o�����Dr^[�Fj6�S�U#1A��z4�1���i$fc���Fb6ft�043�\�*�Fb6���V��l̘p�U#1�Ś`"1���{�~Z$fc�O#��H��0���@"1�L'�p��Eb6�?�Eb6��k��l���׉�����i٘�^�ER&磨�i�8o�N����$��#1#�ʊ�lL�L{$fc*�&�rF?a�\�L),�C�l���*�������C��*���<L����4Y�#T2�ܜ<B)s�r��J�Lc�=B%�?G5�P�d���#����Mb�R&�x��j��vX�:C-�AL�'����s2��	�L�%���LƖ3�J������Y�}�,�
g�f2Z�d�P�d����L(f�\n�����"���,��	�LF��DS(���Wv�B1�p    B�)T3�ѭ�P�d�r�v
�\А��f�P�d��L�f2�ՓC1�̚C1�7L]����L���9T3^�	�LƲ͡�+W�� ���[J�Ks�f2C&�3�2��Ym�M�'�P��uK5&�3��Q	�L��u- ���Z@2HE�'�3h�Z@c��k� �@��NCh��br ��W�b8A��,�Г )����@C*7�jh �A��9��y�B�rL�1h�|N�f2��KC�Ԣ��&�Z��!6'���3�ð�	�L�_=0���;1r�p1�2��o#;d|-o�e�龘+-�H4ؿ����h��<������ �곰���Ɵ���B�bfJa%0����M����p.��H�'�f
w�k` �A��m�fP�'0���PV` Cî����Av��p33�up1�!�X��d�|N$g0������ˊ�lLQ�s�7S�G&3�q��p3�]N`72�]N`73��^h�Z�F���=����n��nfr?�.�r ��s.p1�؟.p3�Q&��1\�&�� �@�!ʙ�$s����n�V�k`7��0���=ʰ����T�<�(�����_�夰6�r9KF3�|�b��30����`f���N\j��)�J�X�7#<�Hxn���n�X8��1!bh�\#�P����#�o��ـ	��og�Ʉz&#<>�F�0]Ȅz&c��[`���S>&�3�ih|�f�yNW(g2�L(g}�Z�sB9�i\R�#�v�`B9�	?=���s�\�:��P�d���	�ܸ"�Ƣ>�00U`B5s/+�U0��L�Z��j&�\�4����UD�	|�1�5�	�L��%��nf$x����paP�����l�������P���t���d��m�\KX��Ӵ�n�;�
��'y�9���d����	V.���L�g2�d�Ꙍ2�k��L�Q�ٛgG�E9{�.��+��5�K��a��lͻеꯃ9�d���:��GO��a�_�V�Z��=��# �2�/����{^�_Ĕ^�er���	��L��L�����������l��"9����y���}��y�P��"�C��FSQw�ܗ����Jn!��������y�Y�=��R2���ٕ�"9~�1�í����=`�UrD�ῢ{⭒�bKs6�]H���A�B$�Gl�*���ښ�N��p=i�=����6|��Q�����nk�!�th=�v�\�w�a|0���pQ9�	��ݜCT.u�O��r!p���!*_�]����@&g3��`�I�s��BTU��9��B�T��-/��U�D�|=�e���#K
�����9H� ]S�M!#�Ii�A*�0�j�I*�F���0B�
��f ��5�'9']�<�3�̰��./d�����ul�a�� qm��ɉg�����d.Lm�q*��lC�Yv�8�/�N"n���xwNS����Ǉ͠˘`����h@���m�<��$ↇ�T[ҝ�z�!���ֻ�Nړ63xRl�~t،���ٍ}m���/��谑�c��s�ʅ�PHw�S���yƞ����< �Ǉ�LXН{�p۱��nxX�eAnx8�xug��H"~p�LI	��VT��do��r]��s�ʅ�l Ap0d�G���xʒ�ఘI$���ؔ�l��"ȼ
ϰb�!b?�ٰ�2��vo���Evֽ{Si��c� �A�Ύ�/�N�'w;;�.D4�)Ax0�T��(:�8�m׻�p��_���Z-�������������������dt�Ql0f2w�5�dF�r�f.����*b�t�U��Γ��s�ʅHHl��w��1���������p�_d$��o��dnx�W�E�X�k�Hfk�08�����UQ`z��v�h�AbF$
DP�(6��I�[��L�--�s������:w�FfJ�H�����;H��A�ߟ�e8����y_�Â�ݟ���<Ҥ���6�(�M�������������z��n�)d縻�Co!��<���;�҄a�ݢw������p��0>��5�����>'���Jf+*�Dx]�(B~�ݢw�$��p ��������D!����s��������mu��F�3��7�m�p ���6S'[n�Io3JO՝�0��0✄�E�t�#�D�X���0/DyKI�a� ���F
c���ߑ�a�bӪ��ƈ�t.~ɍ��^$7F��k��ǈ���:�#��9s!��v�Kqc�F2��q�"x��p�ü�X#�1�0�gd?Fl��k�qc�!-%^�5�W.�[��s�ʗ�|^�ↈ���| ~��O�㇈����pN�\���9�Bи��!b#<�"6���?D���?Dl��?�����A���/솈�0����!/'�F���.�!~��L��v���0�H ��g���-ל���Y&�D1�c1�A��b�0@�ɝ�����hBլ���7.铅c���������`<��ωh?�����[�۸p�ďr'��8W���c�?�e[�;Wl�9｣�����3�����	� ��D\F:/J���S��b��oA>���x
�H��ۇ;w��6�S�A�K��?w�J6�)�� ��K�Sp@Ķ��N����mD-��Sp����;�E�7Q�Sp��\;�)��(G1�;G$�;ޛ1�)��4�6�)�/��%�Sp�z���Ċ���}.!��B��1�SpQK3�)���t�p���y���������Lϝ�# ��ԯ;w�ƥ�Ý�;H����N��S�@� a0��O�m&�N0A���� A�0��>�;�	�
�v����ʏ����[/����@U����r����P��n2=pg����f�3p���'�����a
"�;�� n��ۺ�o)�]�;�v��!��ο}.���a4�W��o_F�t���=ѥ*{cmD�5����m�@�~Ϝ87���'�s��4�[��Tn�CtR��-�sy�ߒ63s�L{b���L��)<�g]����-�@<���t-�!8���a�6��[�� �`Q����7rWNNN��drb�n#�i" ���9�=}w����=�a
o����#"o�S����6�s�@x��!�`Ÿ� ^�ۿFy���-�a�ñ(��[��h|a��;Ha�<]w����z���]Xwnw��Q��{�àY�9��RmK+�	���6R�W�M����L����\5㛸�t��雸��"�ĵ�����L��?W�͎���rM�AJ�����;H�*�隸���.�7q�i�%�&�0�g�5w�ݛ���d\���g̵��Lf<�n����\VnL�L�\V.dZ�U����`z�#���;@-Ԅk���9���q�v�F�0<}�������T_ŋ�M�=�U�Y�j�_a3���5�>����ݞ��ݾ�f��J���"��&����n��f:�Y�k^.d&;�����ۛM���y�m^�Xv�pl���2s
0�����O��<p5�����Jw�����O�T9��x�~?b�B�%}Ν�dd��nK�Ν_)BaA�\�B
O�ΝRyW��N.q1������ӹ�{.;��nc�,h.7�#-�,��5+��'&��'�.I�k�����k�\�h2F�"����p���9C�9�u(o��������j����L�q>?�EJ������������n��kZ��17C#�>1���s홻}��T.g�k�\Ƞ��t�knF�K��̨ך��}��4���3=A��� ��%���Enz{�`x�s�8G����:������/����8^��r ��]���B��x"@=�43����� ���U�P��j�w2�B0�|�9�[t���&�������e�4�Uݜ��/4����n?�y� ��DBw32�8����b�݌\H�D0������Zz� 7  �/���B�cG.&�̜��#$� ܅����\B���R����Z���7�e�"��zou����('@�	�frB�m������W�+�i��޴7��1�2�ۋ�_$�ˬ���P�Q��uԖmX��6�1^�q&A���F���/�8L��d0n�q ᥕ����@�Y�,n�q �HT���@*���& _h��T��@�	ߩ�)ȁzY��&!�_Bn�E���!��MuOo;F�x��	�;MOo_�۷3WB��$��^XSx`E�8Ë�ܝ�nG�,�:��b2o�M�7�����y���* ���&={xA��!����j�������s��KS	9��dAɳ���z��/H�ډ�Ļ�6Tx/��ՕK�S��mC*��i<A�����n�c'�!�܍�9�8�����++�������ַ�����e��Y�y1�Mo�R�*+Q��r^�2B���a�"yԸ�P$o�:����bO���l@������"yB���ӈ�mP^)Ո���n�bD�6H�I`D�6��UA������mP��t@��Bj�z���������r�Z������K3��hL��9��d����G/�L,����±y��P�!j��t�}����;�*��6�S�9����D�r+l؝!���m��-~ Q@�>�&��S�S������� ��՞�����~�fFg��>AH̭�I�%���8zbD����-Hl�|9��T�� �u}���MB�	��� �Y� b�Ԟ�)�Jcu�CĂ�GsO��j��}B"D�Iz�
os��TO����7$nd\ao})_[\i/f�q�J{3�fc|moȮ����b>Q���*/��v�G��5���ͨ�\|qo�&�x��+�qe>_܇�ۊ/��Q�_��x+B��4S�h��#d)ڦ+�e��[|uoHx�7 _��L�r�ս�»�xA��\���U?|����(��ۘʳ^y{��ÂR��mP��Ir��m��P�n��uZ57|[&��F�6�A�F�^WXqq�\���q��mP���H݋4�Y#uT׃"q���a��ȥ���iu��j�m����H��V�L"m4P"�@۵r�W���-ж1v)<�@�`:O����6&�Qd"m$��H��a��E�6�r$~�,�j��i6���u5&R�1�K��m��$0�Hڄ8dO��mP^��G�6HVLꑶ*��E�6���#qd#ƹG�6��\Q�7���m��"m�7"���#�6�^�%�#�6�)�<"m�霎j��h�F��ɍ�+	��	�f@��	���&RV���	����<Cqj�f(nB��� ��&4������~��{rO��'��6hZ:=CqB52��P܄�k* ��&T�PH
�m���䬂��$}R�.$o]�X�7ﺡ���'�'H��@�S�|0��3s6�#�sB�Xu��.��V�xbĲw1Cy� �sD�3�x����WXG�(oc���<@j�bm�*��x+N5�ƌV^�
Ƣ�W�6����!*R�Oz)�_���^h<@�؄�,?�H� J��d�4�&Ĺ��p��f�]�ޝ�_���/D�}2�2���\��u=I{w�uC�߰'���BC�'���*<��;�z ^B�����nY�Q���*@��w�rG]4-�⎺n�3=�dqG]���;�zi%�;�z FeB��*/��6(o<�@j^I�;�z �.��a����sΎ���C&��1�L ���~a0��jݾ�w~�u�F(��A�{� E�6��~$oB�f8&�� v�"y/hZUj$o���F�6��֤����b�F�6Hk�w��mP�'��m���d?�u��"}�m�/n�{�lHEZ$��NkL-�7�n�RZ$o2�k������6["-��d�<�A��	!f=�Pބd�Q�n2�Y��Bu����CuR��Cu�j���&�<H�M1Њ�Mhdn�m/5 ��Ь���P݀3꤇�6h��{�nB��Brs��D��&o٢����z�Yք` ��帒�	�[n��b��&#�� ��{�^���B��      b   ]  x��U�n�H>SOA��K���O���n���:.
��Z���Hv6}����_l9�#;��{�9����H�O`,+�g�qB��p�J����\m&�KL_[J��|~<W��A�y,xI�)�Qe�%����A�Xko��L�[��dQ��i��ʾ������A��p'Et�l� �q'1��Bp�+���{��l2�4��[PϖW��4p�1z��4��H~��^�Q�Y��:z`�,MB�e?���1Jѹ��tz0Ȥ�N�BmT/PI}|u*p()\��iF�N3�>��<����u������\�z�"%;�������Фn��+�w�S�
���(������/G�K|��E��B�=Zd�{*�e�%���v�'�Ģ`l9�{F�8*�d�x@u�¼q;|�	��hEX��Sƕ$�`jr��V8�]����]?��T@��h��x#3�o��@� �E��YQ�=�В���ݭ��G:�+x~�Z��m�U�`�i��s���
~o�Np�#��'�(��~�l7HJK����&���{�,ө"����R�g�m�� Ʊ�gR�����`O-�l��7A;��>׫J�m���8�/�7��_�i��z���s�e��.����e���δ�O��y��/�md�����k�}�ă��A�+���%i��k@va��R/�H������'�|�#�c͂�}�z=�vd���'��,�b^g���jہ�T[�]Y���_^��	|e�=��2�#������#��*O�#7�\/�/�ڋ�*ʎ���۵u��nU�u�8�IǫgN�1�m��|����j�/����/��o��I�s����l�̈o�l,�F�މ��?�.y%      f   U   x����0��0L/�$Nv��s�~�gcb���Pl��I.�4���rcS�FS�f�-K��
�j�o7v��hEմq��߇����      h   ?   x�U���0�7Taa8�0PK��C��{)Jxp9W�N��[y1[����̽mg�=��/�M�      j   ?   x�Uʱ�0��L��!��Y��I���j�&y���I�j',��~A���S��7��}d      d   d   x�3�t,V�M���/J-�4�2�tM�9��$39�3���/KT�I���,.�4�2��L�4��ͬ ���&(��+�'g�-8�2sS3����r��qqq ��!�      `   c   x�3�,�ItH�M���K����I�442�2�LN,��/F��pqsf%�%�d��#�{A�8���L8����M���/˘5�����r1z\\\ ��-r     